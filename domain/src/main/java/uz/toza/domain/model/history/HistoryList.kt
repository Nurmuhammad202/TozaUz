package uz.toza.domain.model.history

import uz.toza.domain.model.QrInfo

data class HistoryList(var type1: Int, var type2: Int, var list: ArrayList<QrInfo>)
