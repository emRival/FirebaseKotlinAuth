package com.rival.firebase.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ModelBuku (

     var namaBuku: String? = null,
var hargaBuku: String? = null,
    var gambarBuku: Int = 0
) : Parcelable