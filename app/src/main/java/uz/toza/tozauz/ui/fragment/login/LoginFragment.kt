package uz.toza.tozauz.ui.fragment.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.toza.tozauz.MainActivity
import uz.toza.tozauz.R
import uz.toza.tozauz.databinding.FragmentLoginBinding


@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            loginViewModel.isLoading.observe(viewLifecycleOwner){
                if (it){
                    loader.visibility = View.VISIBLE
                }else{
                    loader.visibility = View.INVISIBLE
                    requireActivity().finishAffinity()
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                }
            }
            btnSignIn.setOnClickListener {
                loginViewModel.setToken("Nurmuhammad")
                loginViewModel.setAuthToken(txtPhone.text.toString(), txtPassword.text.toString())
            // findNavController().navigate(R.id.action_loginFragment_to_otpSmsFragment)
            }
            backToHome.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}