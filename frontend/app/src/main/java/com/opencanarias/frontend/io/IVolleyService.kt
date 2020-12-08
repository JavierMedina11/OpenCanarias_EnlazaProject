package com.opencanarias.frontend.io

import android.content.Context
import com.opencanarias.frontend.models.User

interface IVolleyService {

    fun registerUser(context: Context, user: User, completionHandler: () -> Unit)

}