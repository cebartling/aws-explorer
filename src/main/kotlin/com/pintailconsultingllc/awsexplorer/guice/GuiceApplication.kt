package com.pintailconsultingllc.awsexplorer.guice

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Injector
import com.pintailconsultingllc.awsexplorer.modules.FoobarModule
import com.pintailconsultingllc.awsexplorer.modules.GuiceModule
import com.google.inject.Provider
import javafx.application.Application
import java.lang.reflect.AccessibleObject
import java.util.*


abstract class GuiceApplication : Application() {

    private var injector: Injector? = null

    /**
     * List of annotations that are not allowed on constructors of
     * `GuiceApplication` instances.
     */
    private var injectAnnotationClasses: Set<Class<out Annotation?>>? = null

    init {
        val injectAnnotationClasses: MutableSet<Class<out Annotation?>> = HashSet()
        injectAnnotationClasses.add(com.google.inject.Inject::class.java)
        injectAnnotationClasses.add(jakarta.inject.Inject::class.java)
        this.injectAnnotationClasses = Collections.unmodifiableSet(injectAnnotationClasses)
    }

    /**
     * To make sure that the initialization of Guice-based JavaFX application
     * works flawlessly, the original init method of the base JavaFX Application
     * class is overwritten here.
     *
     * This class offers it's own method for custom initialization, which will be called
     * during the invocation of this overriden method: [.init].
     */
    @Throws(Exception::class)
    override fun init() {
        super.init()
        val instance = this

        // Checks the GuiceApplication instance and makes sure that none of the constructors is
        // annotated with @Inject!
        for (c in instance.javaClass.getConstructors()) {
            check(!isInjectAnnotationPresent(c)) { "GuiceApplication with constructor that is marked with @Inject is not allowed!" }
        }
        val modules: MutableSet<Module> = HashSet()
//        modules.add(object : AbstractModule() {
//            override fun configure() {
//                bind(javaClass).toProvider(Provider { instance })
//            }
//        })
//        modules.add(FXMLLoadingModule())
//        modules.add(FxApplicationThreadModule())
//        modules.add(PersistentPropertyModule())

        // Propagates initialization of additional modules to the specific
        // subclass of this GuiceApplication instance.
        val additionalModules: List<Module> = ArrayList()
        init(additionalModules)
        modules.addAll(additionalModules)

//        injector = Guice.createInjector()

        // Injects all fields annotated with @Inject into this GuiceApplication instance.
        injector!!.injectMembers(instance)
    }

    /**
     * This method is used to fetch and/or create (Guice) modules necessary
     * to fully construct this application.
     *
     * The modules that are initialized in this method and added to the
     * passed List will be used to create the [Injector] instance that is
     * used in the context of this application.
     * @param modules
     * A list of modules (initially empty) that shall be used to create the
     * injector to be used in the context of this application.
     *
     * @see .getInjector
     * @throws Exception
     * if anything goes wrong during initialization.
     */
    @Throws(java.lang.Exception::class)
    abstract fun init(modules: List<Module?>?)


    /**
     * Returns the Google Guice Injector that is used within the context
     * of this JavaFX Application.
     * @return
     * The Guice Injector that has been created during the initialization
     * of this JavaFX Application.
     * @see .init
     */
    fun getInjector(): Injector? {
        return injector
    }

    /**
     * Helper method to determine whether a given [AccessibleObject] is annotated
     * with one of the Inject annotations known by Guice.
     *
     * @param object
     * Accessible object to be analyzed. Must not be `null`
     * @return
     * `true` if the given object is annotated with an `@Inject` annotation,
     * `false` otherwise.
     *
     * @see javax.inject.Inject
     *
     * @see com.google.inject.Inject
     */
    private fun isInjectAnnotationPresent(`object`: AccessibleObject): Boolean {
        var found = false
        for (annotationClass in injectAnnotationClasses!!) {
            if (`object`.isAnnotationPresent(annotationClass)) {
                found = true
                break
            }
        }
        return found
    }


}