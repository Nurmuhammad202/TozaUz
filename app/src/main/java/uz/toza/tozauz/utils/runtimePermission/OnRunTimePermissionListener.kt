package uz.toza.tozauz.utils.runtimePermission

interface OnRunTimePermissionListener{
    //onPermission Granted...
    fun onPermissionGranted()

    //onPermissionDenied
    fun onPermissionDenied()
}