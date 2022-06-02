# CHANGELOG

## [1.1.5] - 2022-06-03
- Overload `byte` API to allow partial tracing:  
  - `Log#h(String, byte, int, int)`
  - `getByteTraceString#(byte, int, int)`
- Update `Application` with `Application#setInstance(android.app.Application)`
  to allow proper operation for those which can't extend
  `io.cloudwalk.loglibrary.Application` instead of `android.app.Application`
  and will replace `android:name` on their `AndroidManifest.xml` anyway.
- Review CHANGELOG.md content.

## [1.1.4] - 2022-03-21
- Replace `Application#getPackageContext()` by `Application#getContext()`.

## [1.1.3] - 2022-03-09
- Ensure proper queueing of `Sniffer#write(String, String)`.

## [1.1.2] - 2022-01-26
- Ensure no exception will be thrown by `Log#getByteTraceString(byte[], int)`
  when `length` is 'out-of-range' - e.g. '0', '-1', etc.
- Update code patterns.

## [1.1.1] - 2021-11-29
- Ensure the removal of special characters when using log-to-file features.

## [1.1.0] - 2021-11-29
- Add log-to-file features.

## [1.0.2] - 2021-11-16
- Increase `Log#getByteTraceString(byte[], int)` and
  `Log#h(String, byte[], int)` protection against invalid arguments.

## [1.0.1] - 2021-10-04
- Erase unused dependencies from the dependency list. 

## [1.0.0] - 2021-09-30
- Initial release.
