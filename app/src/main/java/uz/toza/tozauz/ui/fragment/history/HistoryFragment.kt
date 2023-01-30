package uz.toza.tozauz.ui.fragment.history

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import uz.toza.tozauz.databinding.FragmentDashboardBinding
import uz.toza.tozauz.ui.adapter.HistoryAdapter
import uz.toza.tozauz.ui.dialog.DatePicter.DataPicterDialog

class HistoryFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[HistoryViewModel::class.java]
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnLeft.setOnClickListener {
                showDialog(1)
            }

            btnRight.setOnClickListener {
                showDialog(2)
            }
            recyclerview.layoutManager = LinearLayoutManager(requireContext())
            recyclerview.adapter = HistoryAdapter()
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