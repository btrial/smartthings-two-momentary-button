metadata {
	definition (name: "Momentary Button", namespace: "btrial", author: "btrial") {
		capability "Actuator"
		capability "Switch"
		capability "Momentary"
		capability "Sensor"
        
		attribute "about", "string"
	}

	tiles(scale: 2) {
		multiAttributeTile(name: "main", type: "generic", width: 6, height: 4, canChangeIcon: true, canChangeBackground: true) {
			tileAttribute("device.switch", key: "PRIMARY_CONTROL") {
				attributeState "off", label: 'Turning OFF', action: "switch.on", backgroundColor: "#ffffff",icon: "https://raw.githubusercontent.com/MichaelStruck/SmartThingsPublic/master/devicetypes/michaelstruck/google-switch.src/GHH-Off.png", nextState: "undefined"
				attributeState "on", label: 'Turning ON', backgroundColor: "#79b821",icon: "https://raw.githubusercontent.com/btrial/icons/master/on.png", nextState: "undefined"
                attributeState "undefined", label: 'Push for ON', action: "switch.on", backgroundColor: "#ffffff",icon: "https://raw.githubusercontent.com/btrial/icons/master/on.png"
			}
        }
        multiAttributeTile(name: "on", type: "generic", width: 6, height: 4, canChangeIcon: true, canChangeBackground: true) {
			tileAttribute("device.switchON", key: "PRIMARY_CONTROL") {
				attributeState "off", label: '', action: "switch.on", backgroundColor: "#ffffff",icon: "https://raw.githubusercontent.com/btrial/icons/master/push-for-ON.png", nextState: "on"
				attributeState "on", label: '', backgroundColor: "#79b821",icon: "https://raw.githubusercontent.com/btrial/icons/master/turning-ON.png"
			}
        }
        multiAttributeTile(name: "off", type: "generic", width: 6, height: 4, canChangeIcon: true, canChangeBackground: true) {
			tileAttribute("device.switchOFF", key: "PRIMARY_CONTROL") {
				attributeState "off", label: '', action: "switch.off", backgroundColor: "#ffffff",icon: "https://raw.githubusercontent.com/btrial/icons/master/push-for-OFF.png", nextState: "on"
				attributeState "on", label: '', backgroundColor: "#F75454",icon: "https://raw.githubusercontent.com/btrial/icons/master/turning-off.png"
			}
        }
        main "main"
		details (["on", "off"])
	}
}

def push() {
}

def on() {
    sendEvent(name: "switchON", value: "on", isStateChange: true, display: false)
    sendEvent(name: "switchON", value: "off", isStateChange: true, display: false)
	
    sendEvent(name: "switch", value: "on", isStateChange: true, display: false)
    sendEvent(name: "switch", value: "undefined", isStateChange: true, display: false)
	sendEvent(name: "momentary", value: "pushed", isStateChange: true)
}

def off() {
	sendEvent(name: "switchOFF", value: "on", isStateChange: true, display: false)
	sendEvent(name: "switchOFF", value: "off", isStateChange: true, display: false)
    
	sendEvent(name: "switch", value: "off", isStateChange: true, display: false)
    sendEvent(name: "switch", value: "undefined", isStateChange: true, display: false)
    sendEvent(name: "momentary", value: "pushed", isStateChange: true)
}