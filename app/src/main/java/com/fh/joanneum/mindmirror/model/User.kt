object User {
    private var username: String = ""
    private var password: String = ""
    private var email: String = ""
    private var nickname: String = ""

    fun getUsername():String{
        return username
    }
    fun setUsername(username:String){
        this.username = username
    }

    fun getPassword():String{
        return password
    }
    fun setPassword(password:String){
        this.password = password
    }

    fun getEmail():String{
        return email
    }
    fun setEmail(email:String){
        this.email = email
    }

    fun getNickname():String{
        return nickname
    }
    fun setNickname(nickname:String){
        this.password = password
    }
}


