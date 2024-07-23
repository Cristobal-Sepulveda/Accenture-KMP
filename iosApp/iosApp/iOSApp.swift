import SwiftUI
import shared

@main
struct iOSApp: App {
    init() {
        KoinInitializerKt.InitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}