package com.example.demo3rdweek.model

import android.os.Parcel
import android.os.Parcelable
import com.example.demo3rdweek.R

data class TimeLifeModel(
    var name: String = "",
    var resourceImage: Int = R.drawable.profile_main_avatar,
    var content: String = "no content",
    var isLike: Boolean = false,
    var time: String = "00 : 00"
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(resourceImage)
        parcel.writeString(content)
        parcel.writeByte(if (isLike) 1 else 0)
        parcel.writeString(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TimeLifeModel> {
        override fun createFromParcel(parcel: Parcel): TimeLifeModel {
            return TimeLifeModel(parcel)
        }

        override fun newArray(size: Int): Array<TimeLifeModel?> {
            return arrayOfNulls(size)
        }
    }
}