package top.hasiy.spinkitProgressBarDemo.view

import android.os.Parcel
import android.os.Parcelable

/*
 * @Author: Hasiy
 * @Date: 2019/11/5 - 15 : 29 
 * @Description: dialogspinkit
 * @Email: Zhuxs@venpoo.com
 */
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
data class ItemData(var itemColor: Int, var itemName: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(itemColor)
        parcel.writeString(itemName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemData> {
        override fun createFromParcel(parcel: Parcel): ItemData {
            return ItemData(parcel)
        }

        override fun newArray(size: Int): Array<ItemData?> {
            return arrayOfNulls(size)
        }
    }
}
