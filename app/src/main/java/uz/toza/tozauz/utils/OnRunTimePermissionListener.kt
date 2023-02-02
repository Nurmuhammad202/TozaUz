package uz.toza.tozauz.utils

interface OnRunTimePermissionListener{
    //onPermission Granted...
    fun onPermissionGranted()

    //onPermissionDenied
    fun onPermissionDenied()
}