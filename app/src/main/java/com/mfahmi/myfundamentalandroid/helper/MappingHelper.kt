package com.mfahmi.myfundamentalandroid.helper

import android.database.Cursor
import android.provider.BaseColumns._ID
import com.mfahmi.myfundamentalandroid.db.DatabaseContract.Companion.AVATAR_URL
import com.mfahmi.myfundamentalandroid.db.DatabaseContract.Companion.USERNAME
import com.mfahmi.myfundamentalandroid.db.DatabaseContract.Companion.USER_TYPE
import com.mfahmi.myfundamentalandroid.model.User

object MappingHelper {

    fun mapCursorToArrayList(userCursor: Cursor?): ArrayList<User> {
        val usersList = ArrayList<User>()

        userCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(_ID))
                val username = getString(getColumnIndexOrThrow(USERNAME))
                val userType = getString(getColumnIndexOrThrow(USER_TYPE))
                val avatarUrl = getString(getColumnIndexOrThrow(AVATAR_URL))
                usersList.add(User(id, username, userType, avatarUrl))
            }
        }
        return usersList
    }

}