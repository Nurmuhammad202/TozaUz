package uz.toza.tozauz.utils

import android.Manifest
import android.content.Context
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

class RuntimePermissionCustom {
    fun permissionList(onRunTimePermissionListener: OnRunTimePermissionListener, context: Context) {
        Dexter.withContext(context)
            .withPermissions(
                Manifest.permission.CAMERA
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    onRunTimePermissionListener.onPermissionGranted()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) {
                    onRunTimePermissionListener.onPermissionDenied()
                }
            }).check()
    }

    fun permissionContact(
        onRunTimePermissionListener: OnRunTimePermissionListener,
        context: Context
    ) {
        Dexter.withContext(context)
            .withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    onRunTimePermissionListener.onPermissionGranted()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) {
                    onRunTimePermissionListener.onPermissionDenied()
                }
            }).check()
    }

    fun permissionCamera(
        context: Context,
        response: (Boolean) -> Unit
    ) {
        Dexter.withContext(context)
            .withPermissions(
                Manifest.permission.CAMERA,
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    response(true)
                    // onRunTimePermissionListener.onPermissionGranted()
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) {
                    response(false)
                    //onRunTimePermissionListener.onPermissionDenied()
                }
            }).check()
    }
}