package services

@Singleton
class Context {
    @Delegate
    Map context = [:]
}
