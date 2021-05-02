package code.solutions.fxmodel

import com.dukascopy.api.Instrument
import com.dukascopy.api.system.ClientFactory
import com.dukascopy.api.system.IClient
import com.dukascopy.api.system.ISystemListener
import org.slf4j.LoggerFactory

class Myfx {
    private val client: IClient = ClientFactory.getDefaultInstance()
    private val logger = LoggerFactory.getLogger("Myfx")
    private val jnlpLive = "https://platform.dukascopy.com/live_3/jforex_3.jnlp"
    private val jnlpDemo = "https://platform.dukascopy.com/demo/jforex.jnlp"

    init {
        client.setSystemListener(object : ISystemListener {
            override fun onStart(processId: Long) {
                logger.debug("onStart(processId=$processId")
            }

            override fun onStop(processId: Long) {
                logger.debug("onStop(processId=$processId)")
            }

            override fun onConnect() {
                logger.debug("onConnect()")
                client.subscribedInstruments = setOf(Instrument.EURUSD)
            }

            override fun onDisconnect() {
                logger.debug("onDisconnect()")
            }
        })
    }

    fun login(login: String, password: String) {
        client.connect(jnlpDemo, login, password)
    }
}