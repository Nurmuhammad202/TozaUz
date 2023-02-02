package uz.toza.tozauz.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import uz.toza.tozauz.R
import uz.toza.tozauz.databinding.FragmentHomeBinding
import uz.toza.tozauz.utils.RuntimePermissionCustom

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnGo.setOnClickListener {
                    RuntimePermissionCustom().permissionCamera( requireContext()){succes->
                        if(succes){
                            findNavController().navigate(R.id.action_navigation_home_to_fragment_qr_code)
                        }else {
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

class MyCalls(){
    fun read(){

    }
}