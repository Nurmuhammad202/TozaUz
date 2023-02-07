package uz.toza.tozauz.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.toza.domain.repository.LocalRepository
import uz.toza.domain.repository.RemoteRepository
import uz.toza.domain.usecase.*

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetBalance(
        remoteRepository: RemoteRepository,
        localRepository: LocalRepository
    ): GetBalanceUseCase {
        return GetBalanceUseCase(
            remoteRepository = remoteRepository,
            localRepository = localRepository
        )
    }


    @Provides
    fun provideHistory(
        remoteRepository: RemoteRepository,
        localRepository: LocalRepository
    ): HistoryUseCase {
        return HistoryUseCase(
            remoteRepository = remoteRepository,
            localRepository = localRepository
        )
    }

    @Provides
    fun providePostQr(
        remoteRepository: RemoteRepository,
        localRepository: LocalRepository
    ): PostQrCodeUseCase {
        return PostQrCodeUseCase(
            remoteRepository = remoteRepository,
            localRepository = localRepository
        )
    }

    @Provides
    fun provideProfile(
        remoteRepository: RemoteRepository,
        localRepository: LocalRepository
    ): ProfileUseCase {
        return ProfileUseCase(
            remoteRepository = remoteRepository,
            localRepository = localRepository
        )
    }

    @Provides
    fun provideQrToday(
        remoteRepository: RemoteRepository,
        localRepository: LocalRepository
    ): QrTodayUseCase {
        return QrTodayUseCase(
            remoteRepository = remoteRepository,
            localRepository = localRepository
        )
    }
}