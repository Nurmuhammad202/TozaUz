package uz.toza.tozauz.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.toza.tozauz.R
import uz.toza.tozauz.databinding.FragmentHomeBinding
import uz.toza.tozauz.utils.runtimePermission.RuntimePermissionCustom

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            homeViewModel.getBalance()
            homeViewModel.todayDate()

            homeViewModel.balance.observe(requireActivity()) {
                txtPrice.text = it
            }

            homeViewModel.qrCodeToday.observe(requireActivity()) {
                txtOne.text = it[0].balance
                txtTwo.text = it[1].balance
            }

            btnQrCode.setOnClickListener {
                RuntimePermissionCustom().permissionCamera(requireContext()) { success ->
                    if (success) {
                        findNavController().navigate(R.id.action_navigation_home_to_fragment_qr_code)
                    } else {
                        Toast.makeText(requireActivity(), R.string.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}