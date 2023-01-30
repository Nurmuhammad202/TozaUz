package uz.toza.tozauz.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.toza.tozauz.R
import uz.toza.tozauz.databinding.FragmentLoginSelectBinding


class LoginSelectFragment : Fragment() {
    private var _binding: FragmentLoginSelectBinding? = null
    private val binding get() = requireNotNull(_binding)
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
            btnRu.setOnClickListener{
                findNavController().navigate(R.id.action_loginSelectFragment_to_loginFragment)
            }

            btnUzb.setOnClickListener {
                findNavController().navigate(R.id.action_loginSelectFragment_to_loginFragment)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}