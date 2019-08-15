package com.example.demo3rdweek.model

import android.os.Parcel
import android.os.Parcelable

data class InBoxModel(
    var name: String = "",
    var messContent: String = "no content",
    var time: String = "00 : 00",
    var numberMess: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(messContent)
        parcel.writeString(time)
        parcel.writeInt(numberMess)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InBoxModel> {
        override fun createFromParcel(parcel: Parcel): InBoxModel {
            return InBoxModel(parcel)
        }

        override fun newArray(size: Int): Array<InBoxModel?> {
            return arrayOfNulls(size)
        }
    }
}
