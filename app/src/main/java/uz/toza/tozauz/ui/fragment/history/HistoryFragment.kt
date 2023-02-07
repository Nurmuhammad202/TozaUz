package uz.toza.tozauz.ui.fragment.history

import android.content.ContentValues.TAG
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import uz.toza.tozauz.databinding.FragmentDashboardBinding
import uz.toza.tozauz.ui.adapter.HistoryAdapter
import uz.toza.tozauz.ui.dialog.DatePicter.DataPicterDialog

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val dashboardViewModel: HistoryViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dashboardViewModel.getHistory("01.01.2023", "02.01.2023")


        binding.apply {
            btnLeft.setOnClickListener {
                showDialog(1)
            }

            btnRight.setOnClickListener {
                showDialog(2)
            }
            recyclerview.layoutManager = LinearLayoutManager(requireContext())
            dashboardViewModel.getOrderHistory.observe(requireActivity()) {
                recyclerview.adapter = HistoryAdapter(it)
                binding.loader.visibility=View.GONE
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun showDialog(type: Int) {
        val dialog = DataPicterDialog(requireContext(), type = type.toString())
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}