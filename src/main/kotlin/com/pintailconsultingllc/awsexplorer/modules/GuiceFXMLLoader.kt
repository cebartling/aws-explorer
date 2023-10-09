package com.pintailconsultingllc.awsexplorer.modules

import com.google.inject.Injector
import jakarta.inject.Inject
import javafx.fxml.FXMLLoader
import javafx.util.Callback
import java.io.IOException
import java.net.URL
import java.util.*

interface GuiceFXMLLoader {
    fun <N> load(url: URL, resources: ResourceBundle?): N
}

class GuiceFXMLLoaderImpl : GuiceFXMLLoader {

    /**
     * Guice Injector that will be used to fetch an instance of our `controller
     * class`.
     */
    @Inject
    private lateinit var injector: Injector

//    @Inject
//    fun GuiceFXMLLoader(injector: Injector?) {
//        this.injector = injector
//    }

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
    override fun <N> load(url: URL, resources: ResourceBundle?): N {
        val loader = FXMLLoader()
        loader.location = url
        loader.resources = resources
        loader.controllerFactory = Callback<Class<*>, Any> { controllerClass: Class<*>? ->
            // Use our Guice injector to fetch an instance of the desired
            // controller class
            injector.getInstance(controllerClass)
        }
        return loader.load(url.openStream()) as N
    }

}