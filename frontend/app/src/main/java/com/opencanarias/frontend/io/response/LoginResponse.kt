package com.opencanarias.frontend.io.response

import com.opencanarias.frontend.models.User

class LoginResponse (val success: Boolean, val user: User, val token: String)