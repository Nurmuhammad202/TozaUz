package uz.toza.tozauz.ui.fragment.login

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.toza.tozauz.R
import uz.toza.tozauz.databinding.FragmentLoginSelectBinding
import uz.toza.tozauz.ui.fragment.profile.ProfileViewModel
import java.util.*

@AndroidEntryPoint
class LoginSelectFragment : Fragment() {
    private var _binding: FragmentLoginSelectBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: ProfileViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnRu.setOnClickListener {
                viewModel.setLang("ru")
                languageUpdate("ru")
                findNavController().navigate(R.id.action_loginSelectFragment_to_loginFragment)
            }

            btnUzb.setOnClickListener {
                viewModel.setLang("uz")
                languageUpdate("uz")
                findNavController().navigate(R.id.action_loginSelectFragment_to_loginFragment)
            }

        }
        onBackPassed()
    }


    private fun onBackPassed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finishAffinity()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun languageUpdate(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}