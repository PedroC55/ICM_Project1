package com.example.myapplication.fragments


import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


@ExperimentalGetImage class AnalyzeTextFragment : Fragment(R.layout.fragment_text_analyzer) {
    private var imageCapture: ImageCapture? = null

    //var text2: TextView
    private lateinit var cameraExecutor: ExecutorService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_text_analyzer, container, false)
        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)




        return view
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            requireContext(), it
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            // Used to bind the lifecycle of cameras to the lifecycle owner
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            // Preview
            val vF = requireActivity().findViewById<PreviewView>(R.id.viewFinder)
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(vF.surfaceProvider)
                }

            imageCapture = ImageCapture.Builder().build()


            val imageIDK = ImageAnalysis.Builder()
                .build()

            val cameraExecutor = Executors.newSingleThreadExecutor()

            imageIDK.setAnalyzer(cameraExecutor, ImageAnalysis.Analyzer {
                analyze(it)
            })

            // Select back camera as a default
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageIDK
                )


            } catch (exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(requireContext()))
    }

    companion object {
        private const val TAG = "CameraXApp"
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private const val REQUEST_CODE_PERMISSIONS = 10
        private val REQUIRED_PERMISSIONS =
            mutableListOf(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO
            ).apply {
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) {
                    add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }.toTypedArray()
    }

    fun analyze(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            val scanner = BarcodeScanning.getClient()
            val result = scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    for (barcode in barcodes) {
                        val bounds = barcode.boundingBox
                        val corners = barcode.cornerPoints

                        val rawValue = barcode.rawValue

                        val valueType = barcode.valueType
                        // See API reference for complete list of supported types
                        when (valueType) {
                            Barcode.TYPE_URL -> {
                                val title = barcode.url!!.title
                                val url = barcode.url!!.url
                                var q = title + "\n" + url
                                var qrcodeText = requireActivity().findViewById<TextView>(R.id.tvScannedData)
                                qrcodeText.text = getString(R.string.qrcodeText, q)
                                qrcodeText.visibility = View.VISIBLE
                            }
                            Barcode.TYPE_TEXT -> {
                                val text = barcode.rawValue!!.toString()
                                var qrcodeText = requireActivity().findViewById<TextView>(R.id.tvScannedData)
                                qrcodeText.text = getString(R.string.qrcodeText, text)
                                qrcodeText.visibility = View.VISIBLE
                            }
                        }
                    }
                }
                .addOnFailureListener {
                    Log.e(TAG, it.message ?: it.toString())
                }
                .addOnCompleteListener {
                    imageProxy.close()

                }

        }
    }

}