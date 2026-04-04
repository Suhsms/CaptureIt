import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Replace with your actual base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideSpeciesIdentificationApi(retrofit: Retrofit): SpeciesIdentificationApi {
        return retrofit.create(SpeciesIdentificationApi::class.java)
    }

    @Provides
    fun provideRarityApi(retrofit: Retrofit): RarityApi {
        return retrofit.create(RarityApi::class.java)
    }
}