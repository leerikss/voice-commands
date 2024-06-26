package fi.leif.android.voicecommands.mappers

import android.content.Context
import fi.leif.android.voicecommands.R
import fi.leif.voicecommands.RtcType
import fi.leif.voicecommands.RtcType.*

class RtcTypeMapper {

    companion object {

        private val rtc_types = listOf(
            MESSAGE,
            AUDIO_CALL
        )

        fun getRtcTypeName(context: Context, rtcType: String): String {
            return getRtcTypeName(context, valueOf(rtcType))
        }

        fun getRtcTypeName(context: Context, rtcType: RtcType): String {
            val resourceId: Int = when(rtcType) {
                MESSAGE -> R.string.rtc_type_message
                AUDIO_CALL -> R.string.rtc_type_audio
                VIDEO_CALL -> R.string.rtc_type_video
                UNRECOGNIZED -> R.string.unrecognized
            }
            return context.getString(resourceId)
        }

        fun getAllRtcTypeNames(context: Context): Array<String> {
            return rtc_types
                .map { rtcType -> getRtcTypeName(context, rtcType) }
                .toTypedArray()
        }

        fun getRtcTypeAt(position: Int): RtcType {
            return rtc_types[position]
        }
    }
}

