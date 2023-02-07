package uz.toza.tozauz.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.toza.domain.repository.RemoteRepository
import uz.toza.domain.usecase.*

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetBalance(remoteRepository: RemoteRepository): GetBalanceUseCase {
        return GetBalanceUseCase(remoteRepository = remoteRepository)
    }


    @Provides
    fun provideHistory(remoteRepository: RemoteRepository): HistoryUseCase {
        return HistoryUseCase(remoteRepository = remoteRepository)
    }

    @Provides
    fun providePostQr(remoteRepository: RemoteRepository): PostQrCodeUseCase {
        return PostQrCodeUseCase(remoteRepository = remoteRepository)
    }

    @Provides
    fun provideProfile(remoteRepository: RemoteRepository): ProfileUseCase {
        return ProfileUseCase(remoteRepository = remoteRepository)
    }

    @Provides
    fun provideQrToday(remoteRepository: RemoteRepository): QrTodayUseCase {
        return QrTodayUseCase(remoteRepository = remoteRepository)
    }
}