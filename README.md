# Log Library

Even though `android.util.log` is `final`, the Log Library was designed to
extend it. Its public API mirrors the former, simplifying swap or replacement.  

## Features

- _byte[]_ stream trace
  - `Log.h(String, byte[], int)`
  - `Log.getByteTraceString(byte[], int)`
- log-to-file
  - `Log.export()`
  - `Log.s(int, String, String)`
  - `Log.s(int, String, String, Throwable)`

## Dependencies

Due to its very fundamental scope, the Log Library was designed to be
independent of local or copyrighted packages of any type.  

## Local publishing

1. Rebuild the `release` variant based on a tag or commit of your choice.
2. Run task: `gradle publishToMavenLocal`
