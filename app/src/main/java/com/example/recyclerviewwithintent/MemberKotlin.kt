package com.example.recyclerviewwithintent

import android.os.Parcel
import android.os.Parcelable

class MemberKotlin() : Parcelable {
    private val name: String? = null
    private val age = 0

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MemberKotlin> {
        override fun createFromParcel(parcel: Parcel): MemberKotlin {
            return MemberKotlin(parcel)
        }

        override fun newArray(size: Int): Array<MemberKotlin?> {
            return arrayOfNulls(size)
        }
    }
}
