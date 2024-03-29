package com.example.blogandchat.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.blogandchat.R
import com.example.blogandchat.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private val viewModel: SignInViewModel by viewModels()
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in)

        viewModel.uiState.observe(this) { uiState ->
            uiState?.let {
                if (uiState.result == true) {
                    Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else if (uiState.check == false) {
                    Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(
                        this,
                        "Đăng nhập thất bại. Vui lòng kiểm tra lại mật khẩu hoặc email",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        binding.buttonSignIn.setOnClickListener {
            //userSignIn()
            viewModel.userSignIn(binding.edtSignInName.text.toString().trim(), binding.edtSignInPass.text.toString().trim())
        }

        binding.signUpText.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

    }

    private fun userSignIn() {
//        val email: String = edt_sign_in_name.text.toString().trim {it <= ' '}
//        val pass: String = edt_sign_in_pass.text.toString().trim {it <= ' '}
//
//        if(email.isNotEmpty() && pass.isNotEmpty()) {
//                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass).addOnCompleteListener { taskId ->
//                    if (taskId.isSuccessful) {
//                        val firebaseUser: FirebaseUser = taskId.result!!.user!!
//                        val registerdEmail = firebaseUser.email!!
//                        Toast.makeText(this, "dang nhap thang cong", Toast.LENGTH_LONG).show()
//                        //FirebaseAuth.getInstance().signOut()
//                        startActivity(Intent(this, MainActivity::class.java))
//                        finish()
//                    }
//                    else {
//                        Toast.makeText(this, taskId.exception!!.message, Toast.LENGTH_SHORT).show()
//                    }
//                }
//        }
//        else {
//            Toast.makeText(this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show()
//        }
    }
}