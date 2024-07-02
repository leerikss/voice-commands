package fi.leif.android.voicecommands

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import fi.leif.android.voicecommands.audio.DefaultSpeechToTextFactory
import fi.leif.android.voicecommands.audio.SpeechToText
import fi.leif.android.voicecommands.audio.SpeechToTextFactory
import fi.leif.android.voicecommands.audio.SpeechToTextListener
import fi.leif.android.voicecommands.executors.CommandLauncher
import fi.leif.android.voicecommands.repositories.AppRepository
import fi.leif.android.voicecommands.repositories.ContactsRepository
import fi.leif.android.voicecommands.repositories.settings.SettingsRepository

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideSettingsRepository(@ApplicationContext context: Context): SettingsRepository {
        return SettingsRepository(context)
    }

    @Provides
    fun provideCommandLauncher(@ApplicationContext context: Context): CommandLauncher {
        return CommandLauncher(context)
    }

    @Provides
    fun provideSpeechToText(): SpeechToTextFactory {
        return DefaultSpeechToTextFactory()
    }

    @Provides
    fun provideAppRepository(@ApplicationContext context: Context): AppRepository {
        return AppRepository(context)
    }

    @Provides
    fun proviceContactRepository(@ApplicationContext context: Context): ContactsRepository {
        return ContactsRepository(context)
    }
}