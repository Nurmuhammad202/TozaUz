package uz.toza.tozauz.ui.fragment.profile

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.toza.tozauz.R
import uz.toza.tozauz.databinding.FragmentProfileBinding
import uz.toza.tozauz.ui.dialog.lang.LangChangeDialog
import java.util.*


@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: ProfileViewModel by viewModels()
    private var lang = "ru"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getLang()

        binding.apply {
            btnCreateCard.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_profile_to_fragment_add_card)
            }

            viewModel.lang.observe(requireActivity()) {
                lang = it
            }

            btnLang.setOnClickListener {
                val dialog = LangChangeDialog(requireContext()) {
                    if (it != lang) {
                        viewModel.setLang(it)
                        languageUpdate(it)
                    }
                }
                dialog.show()
            }


        }
    }

    private fun languageUpdate(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
        activity?.recreate()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}