package com.pintailconsultingllc.awsexplorer.modules

import com.google.inject.Injector
import jakarta.inject.Inject
import javafx.fxml.FXMLLoader
import javafx.util.Callback
import java.io.IOException
import java.net.URL
import java.util.*

interface GuiceFXMLLoader {
    fun <N> load(url: URL, resources: ResourceBundle): N
    fun <N> load(url: URL): N
}

class GuiceFXMLLoaderImpl : GuiceFXMLLoader {

    /**
     * Guice Injector that will be used to fetch an instance of our `controller
     * class`.
     */
    @Inject
    private lateinit var injector: Injector

    /**
     * Loads an object hierarchy from a FXML document
     *
     * A simple wrapper around the
     * [load method][FXMLLoader.load]
     * of JavaFX's FXMLLoader class that adds a tiny notch of Guice-related
     * magic.
     *
     * @param url
     * URL of the FXML resource to be loaded
     * @param resources    Resources to be used to populate
     * @return The loaded object hierarchy
     * @throws IOException
     * @see {@link FXMLLoader.load
     */
    @Throws(IOException::class)
    override fun <N> load(url: URL, resources: ResourceBundle): N {
        val loader = FXMLLoader()
        loader.location = url
        loader.resources = resources
        loader.controllerFactory = Callback { controllerClass: Class<*>? ->
            injector.getInstance(controllerClass)
        }
        return loader.load(url.openStream()) as N
    }

    @Throws(IOException::class)
    override fun <N> load(url: URL): N {
        val loader = FXMLLoader()
        loader.location = url
        loader.controllerFactory = Callback { controllerClass: Class<*>? ->
            injector.getInstance(controllerClass)
        }
        return loader.load(url.openStream()) as N
    }

}