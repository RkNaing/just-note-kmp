import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    
    init() {
        KoinKt.setupKoinIOS()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
