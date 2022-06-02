# Log Library

`io.cloudwalk.loglibrary` was designed to explicitly extend `android.util.log`.
Its public API mirrors the OS's default, simplifying swap or replacement.  

## Library features

- _byte[]_ stream trace
  - `Log.getByteTraceString(byte[], int)`
  - `Log.getByteTraceString(byte[], int, int)`
  - `Log.h(String, byte[], int)`
  - `Log.h(String, byte[], int, int)`
- log-to-file
  - `Log.export()`
  - `Log.s(int, String, String)`
  - `Log.s(int, String, String, Throwable)`

## Dependencies

Due to its very fundamental scope, `io.cloudwalk.loglibrary` was designed to be
independent of local or copyrighted packages of any type.  

## Local publishing

1. Rebuild the `release` variant based on a tag or commit of your choice.
2. Run task: `gradle publishToMavenLocal`

Local publishing within this repository is actually set to use the `release`
build variant only.  

## Development notes

Those who have already extended `android.app.Application` may face a fatal
failure at build time after adding `io.cloudwalk.loglibrary` as a dependency.  
There are two options to bypass such failure, keeping all of the library
original features:  

1. Extend `io.cloudwalk.loglibrary.Application` instead of
`android.app.Application` and ensure to include `tools:replace="android:name"`
in the application's `AndroidManifest.xml`.
   - `io.cloudwalk.loglibrary.Application` was designed to merely intercept and
   cache the application instance for internal usage. It doesn't change
   `android.app.Application` behavior. No side effects are expected.
2. Include `tools:replace="android:name"` in the application's
`AndroidManifest.xml` and invoke
`io.cloudwalk.loglibrary.Application#setInstance(android.app.Application)`
prior to any other calls to `io.cloudwalk.loglibrary`.
