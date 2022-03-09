# CHANGELOG

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
- Erase dependency list to shrink final package. 

## [1.0.0] - 2021-09-30
- Initial release.
