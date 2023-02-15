package uz.toza.tozauz.ui.fragment.login

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import uz.toza.tozauz.MainActivity
import uz.toza.tozauz.R
import uz.toza.tozauz.databinding.FragmentLauncherBinding
import kotlin.math.log

@AndroidEntryPoint
class FragmentLauncher : Fragment() {
    private val loginViewModel: LoginViewModel by viewModels()
    private var _binding: FragmentLauncherBinding? = null
    private val binding get() = requireNotNull(_binding)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLauncherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val result = CoroutineScope(Dispatchers.Main).async {
            val token = loginViewModel.getToken()
            delay(timeMillis = 1000)
            if (token == "") {
                //  findNavController().popBackStack()
                findNavController().navigate(R.id.action_fragment_launcher_to_loginSelectFragment)
            } else {
                startActivity(Intent(requireContext(), MainActivity::class.java))
                requireActivity().finishAffinity()
            }
            true
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}