package fi.leif.android.voicecommands.view.fragments.actions

import fi.leif.voicecommands.Command
import fi.leif.voicecommands.ParameterKeys
import fi.leif.voicecommands.RtcType

class TelegramFragment: RtcFragment() {

    override fun fetchContacts() {
        viewModel.fetchTelegramContacts()
    }

    override fun setUpdateMode(command: Command) {
        val rtcValue: String? = getParamVal(command, ParameterKeys.RTC_TYPE)
        rtcValue?.let { viewModel.setSelectedRtcType(RtcType.valueOf(it)) }
        val contactValue: String? = getParamVal(command, ParameterKeys.CONTACT_ID)
        contactValue?.let { viewModel.setSelectedContactByValue(it) }
    }

}