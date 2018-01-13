package com.jme3.audio.openal;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/**
 * @author iwgeric
 */
public interface AL {

    /**
     * Boolean False.
     */
    static final int AL_FALSE = 0;

    /**
     * Boolean True.
     */
    static final int AL_TRUE = 1;

    /* "no distance model" or "no buffer" */ int AL_NONE = 0;

    /**
     * Indicate Source has relative coordinates.
     */
    static final int AL_SOURCE_RELATIVE = 0x202;

    /**
     * Directional source, inner cone angle, in degrees. Range: [0-360] Default:
     * 360
     */
    static final int AL_CONE_INNER_ANGLE = 0x1001;

    /**
     * Directional source, outer cone angle, in degrees. Range: [0-360] Default:
     * 360
     */
    static final int AL_CONE_OUTER_ANGLE = 0x1002;

    /**
     * Specify the pitch to be applied at source. Range: [0.5-2.0] Default: 1.0
     */
    static final int AL_PITCH = 0x1003;

    /**
     * Specify the current location in three dimensional space. OpenAL, like
     * OpenGL, uses a right handed coordinate system, where in a frontal default
     * view X (thumb) points right, Y points up (index finger), and Z points
     * towards the viewer/camera (middle finger). To switch from a left handed
     * coordinate system, flip the sign on the Z coordinate. Listener position
     * is always in the world coordinate system.
     */
    static final int AL_POSITION = 0x1004;

    /**
     * Specify the current direction.
     */
    static final int AL_DIRECTION = 0x1005;

    /**
     * Specify the current velocity in three dimensional space.
     */
    static final int AL_VELOCITY = 0x1006;

    /**
     * Indicate whether source is looping. Type: ALboolean? Range: [AL_TRUE,
     * AL_FALSE] Default: FALSE.
     */
    static final int AL_LOOPING = 0x1007;

    /**
     * Indicate the buffer to provide sound samples. Type: ALuint. Range: any
     * valid Buffer id.
     */
    static final int AL_BUFFER = 0x1009;

    /**
     * Indicate the gain (volume amplification) applied. Type: ALfloat. Range:
     * ]0.0- ] A value of 1.0 means un-attenuated/unchanged. Each division by 2
     * equals an attenuation of -6dB. Each multiplicaton with 2 equals an
     * amplification of +6dB. A value of 0.0 is meaningless with respect to a
     * logarithmic scale; it is interpreted as zero volume - the channel is
     * effectively disabled.
     */
    static final int AL_GAIN = 0x100A;

    /*
     * Indicate minimum source attenuation
     * Type: ALfloat
     * Range:  [0.0 - 1.0]
     *
     * Logarthmic
     */ int AL_MIN_GAIN = 0x100D;

    /**
     * Indicate maximum source attenuation Type: ALfloat Range: [0.0 - 1.0]
     *
     * Logarthmic
     */
    static final int AL_MAX_GAIN = 0x100E;

    /**
     * Indicate listener orientation.
     *
     * at/up
     */
    static final int AL_ORIENTATION = 0x100F;

    /**
     * Source state information.
     */
    static final int AL_SOURCE_STATE = 0x1010;
    static final int AL_INITIAL = 0x1011;
    static final int AL_PLAYING = 0x1012;
    static final int AL_PAUSED = 0x1013;
    static final int AL_STOPPED = 0x1014;

    /**
     * Buffer Queue params
     */
    static final int AL_BUFFERS_QUEUED = 0x1015;
    static final int AL_BUFFERS_PROCESSED = 0x1016;

    /**
     * Source buffer position information
     */
    static final int AL_SEC_OFFSET = 0x1024;
    static final int AL_SAMPLE_OFFSET = 0x1025;
    static final int AL_BYTE_OFFSET = 0x1026;

    /*
     * Source type (Static, Streaming or undetermined)
     * Source is Static if a Buffer has been attached using AL_BUFFER
     * Source is Streaming if one or more Buffers have been attached using alSourceQueueBuffers
     * Source is undetermined when it has the NULL buffer attached
     */ int AL_SOURCE_TYPE = 0x1027;
    static final int AL_STATIC = 0x1028;
    static final int AL_STREAMING = 0x1029;
    static final int AL_UNDETERMINED = 0x1030;

    /**
     * Sound samples: format specifier.
     */
    static final int AL_FORMAT_MONO8 = 0x1100;
    static final int AL_FORMAT_MONO16 = 0x1101;
    static final int AL_FORMAT_STEREO8 = 0x1102;
    static final int AL_FORMAT_STEREO16 = 0x1103;

    /**
     * source specific reference distance Type: ALfloat Range: 0.0 - +inf
     *
     * At 0.0, no distance attenuation occurs. Default is 1.0.
     */
    static final int AL_REFERENCE_DISTANCE = 0x1020;

    /**
     * source specific rolloff factor Type: ALfloat Range: 0.0 - +inf
     *
     */
    static final int AL_ROLLOFF_FACTOR = 0x1021;

    /**
     * Directional source, outer cone gain.
     *
     * Default: 0.0 Range: [0.0 - 1.0] Logarithmic
     */
    static final int AL_CONE_OUTER_GAIN = 0x1022;

    /**
     * Indicate distance above which sources are not attenuated using the
     * inverse clamped distance model.
     *
     * Default: +inf Type: ALfloat Range: 0.0 - +inf
     */
    static final int AL_MAX_DISTANCE = 0x1023;

    /**
     * Sound samples: frequency, in units of Hertz [Hz]. This is the number of
     * samples per second. Half of the sample frequency marks the maximum
     * significant frequency component.
     */
    static final int AL_FREQUENCY = 0x2001;
    static final int AL_BITS = 0x2002;
    static final int AL_CHANNELS = 0x2003;
    static final int AL_SIZE = 0x2004;

    /**
     * Buffer state.
     *
     * Not supported for public use (yet).
     */
    static final int AL_UNUSED = 0x2010;
    static final int AL_PENDING = 0x2011;
    static final int AL_PROCESSED = 0x2012;

    /**
     * Errors: No Error.
     */
    static final int AL_NO_ERROR = 0;

    /**
     * Invalid Name paramater passed to AL call.
     */
    static final int AL_INVALID_NAME = 0xA001;

    /**
     * Invalid parameter passed to AL call.
     */
    static final int AL_INVALID_ENUM = 0xA002;

    /**
     * Invalid enum parameter value.
     */
    static final int AL_INVALID_VALUE = 0xA003;

    /**
     * Illegal call.
     */
    static final int AL_INVALID_OPERATION = 0xA004;

    /**
     * No mojo.
     */
    static final int AL_OUT_OF_MEMORY = 0xA005;

    /**
     * Context strings: Vendor Name.
     */
    static final int AL_VENDOR = 0xB001;
    static final int AL_VERSION = 0xB002;
    static final int AL_RENDERER = 0xB003;
    static final int AL_EXTENSIONS = 0xB004;

    /**
     * Global tweakage.
     */
    /**
     * Doppler scale. Default 1.0
     */
    static final int AL_DOPPLER_FACTOR = 0xC000;

    /**
     * Tweaks speed of propagation.
     */
    static final int AL_DOPPLER_VELOCITY = 0xC001;

    /**
     * Speed of Sound in units per second
     */
    static final int AL_SPEED_OF_SOUND = 0xC003;

    /**
     * Distance models
     *
     * used in conjunction with DistanceModel
     *
     * implicit: NONE, which disances distance attenuation.
     */
    static final int AL_DISTANCE_MODEL = 0xD000;
    static final int AL_INVERSE_DISTANCE = 0xD001;
    static final int AL_INVERSE_DISTANCE_CLAMPED = 0xD002;
    static final int AL_LINEAR_DISTANCE = 0xD003;
    static final int AL_LINEAR_DISTANCE_CLAMPED = 0xD004;
    static final int AL_EXPONENT_DISTANCE = 0xD005;
    static final int AL_EXPONENT_DISTANCE_CLAMPED = 0xD006;

    //
    ///* Listener parameter value ranges and defaults. */
    //#define AL_MIN_METERS_PER_UNIT                   FLT_MIN
    //#define AL_MAX_METERS_PER_UNIT                   FLT_MAX
    //#define AL_DEFAULT_METERS_PER_UNIT               (1.0f)

    String alGetString(int parameter);

    /**
     * Requests a number of source names.
     *
     * @return the number of source names.
     */
    int alGenSources();

    /**
     * Obtains error information.
     * <p>
     * <p>Each detectable error is assigned a numeric code. When an error is detected by AL, a flag is set and the error code is recorded. Further errors, if they
     * occur, do not affect this recorded code. When alGetError is called, the code is returned and the flag is cleared, so that a further error will again
     * record its code. If a call to alGetError returns AL_NO_ERROR then there has been no detectable error since the last call to alGetError (or since the AL
     * was initialized).</p>
     * <p>
     * <p>Error codes can be mapped to strings. The alGetString function returns a pointer to a constant (literal) string that is identical to the identifier used
     * for the enumeration value, as defined in the specification.</p>
     */
    int alGetError();

    /**
     * Requests the deletion of a number of sources.
     *
     * @param numSources the number of sources.
     * @param sources    the sources to delete.
     */
    void alDeleteSources(int numSources, IntBuffer sources);

    /**
     * Requests a number of buffer names.
     *
     * @param numBuffers the number of buffers.
     * @param buffers    the buffer that will receive the buffer names.
     */
    void alGenBuffers(int numBuffers, IntBuffer buffers);

    /**
     * Requests the deletion of a number of buffers.
     *
     * @param numBuffers the number of buffers.
     * @param buffers    the buffers to delete.
     */
    void alDeleteBuffers(int numBuffers, IntBuffer buffers);

    /**
     * Sets the source state to AL_STOPPED.
     * <p>
     * <p>alSourceStop applied to an AL_INITIAL source is a legal NOP. alSourceStop applied to a AL_PLAYING source will change its state to AL_STOPPED. The source
     * is exempt from processing, its current state is preserved. alSourceStop applied to a AL_PAUSED source will change its state to AL_STOPPED, with the same
     * consequences as on a AL_PLAYING source. alSourceStop applied to a AL_STOPPED source is a legal NOP.</p>
     *
     * @param source the source to stop.
     */
    void alSourceStop(int source);

    /**
     * Integer version of {@link #alSourcef Sourcef}.
     *
     * @param source the source to modify.
     * @param param  the parameter to modify.
     * @param value  the parameter value.
     */
    void alSourcei(int source, int param, int value);

    /**
     * Sets the sample data of the specified buffer.
     * <p>
     * <p>The data specified is copied to an internal software, or if possible, hardware buffer. The implementation is free to apply decompression, conversion,
     * resampling, and filtering as needed.</p>
     * <p>
     * <p>8-bit data is expressed as an unsigned value over the range 0 to 255, 128 being an audio output level of zero.</p>
     * <p>
     * <p>16-bit data is expressed as a signed value over the range -32768 to 32767, 0 being an audio output level of zero. Byte order for 16-bit values is
     * determined by the native format of the CPU.</p>
     * <p>
     * <p>Stereo data is expressed in an interleaved format, left channel sample followed by the right channel sample.</p>
     * <p>
     * <p>Buffers containing audio data with more than one channel will be played without 3D spatialization features – these formats are normally used for
     * background music.</p>
     *
     * @param buffer    the buffer to modify.
     * @param format    the data format. One of:<br><table><tr><td>{@link #AL_FORMAT_MONO8 FORMAT_MONO8}</td><td>{@link #AL_FORMAT_MONO16 FORMAT_MONO16}</td><td>{@link #AL_FORMAT_STEREO8 FORMAT_STEREO8}</td><td>{@link #AL_FORMAT_STEREO16 FORMAT_STEREO16}</td></tr></table>
     * @param data      the sample data.
     * @param frequency the data frequency.
     */
    void alBufferData(int buffer, int format, ByteBuffer data, int size, int frequency);

    /**
     * Sets the source state to AL_PLAYING.
     * <p>
     * <p>alSourcePlay applied to an AL_INITIAL source will promote the source to AL_PLAYING, thus the data found in the buffer will be fed into the processing,
     * starting at the beginning. alSourcePlay applied to a AL_PLAYING source will restart the source from the beginning. It will not affect the configuration,
     * and will leave the source in AL_PLAYING state, but reset the sampling offset to the beginning. alSourcePlay applied to a AL_PAUSED source will resume
     * processing using the source state as preserved at the alSourcePause operation. alSourcePlay applied to a AL_STOPPED source will propagate it to
     * AL_INITIAL then to AL_PLAYING immediately.</p>
     *
     * @param source the source to play.
     */
    void alSourcePlay(int source);

    /**
     * Sets the source state to AL_PAUSED.
     * <p>
     * <p>alSourcePause applied to an AL_INITIAL source is a legal NOP. alSourcePause applied to a AL_PLAYING source will change its state to AL_PAUSED. The
     * source is exempt from processing, its current state is preserved. alSourcePause applied to a AL_PAUSED source is a legal NOP. alSourcePause applied to a
     * AL_STOPPED source is a legal NOP.</p>
     *
     * @param source the source to pause.
     */
    void alSourcePause(int source);

    /**
     * Sets the float value of a source parameter.
     *
     * @param source the source to modify.
     * @param param  the parameter to modify. One of:<br><table><tr><td>{@link #AL_CONE_INNER_ANGLE CONE_INNER_ANGLE}</td><td>{@link #AL_CONE_OUTER_ANGLE CONE_OUTER_ANGLE}</td><td>{@link #AL_PITCH PITCH}</td><td>{@link #AL_DIRECTION DIRECTION}</td><td>{@link #AL_LOOPING LOOPING}</td><td>{@link #AL_BUFFER BUFFER}</td><td>{@link #AL_SOURCE_STATE SOURCE_STATE}</td></tr><tr><td>{@link #AL_CONE_OUTER_GAIN CONE_OUTER_GAIN}</td><td>{@link #AL_SOURCE_TYPE SOURCE_TYPE}</td><td>{@link #AL_POSITION POSITION}</td><td>{@link #AL_VELOCITY VELOCITY}</td><td>{@link #AL_GAIN GAIN}</td><td>{@link #AL_REFERENCE_DISTANCE REFERENCE_DISTANCE}</td><td>{@link #AL_ROLLOFF_FACTOR ROLLOFF_FACTOR}</td></tr><tr><td>{@link #AL_MAX_DISTANCE MAX_DISTANCE}</td></tr></table>
     * @param value  the parameter value.
     */
    void alSourcef(int source, int param, float value);

    /**
     * Sets the 3 dimensional values of a source parameter.
     *
     * @param source the source to modify.
     * @param param  the parameter to modify. One of:<br><table><tr><td>{@link #AL_CONE_INNER_ANGLE CONE_INNER_ANGLE}</td><td>{@link #AL_CONE_OUTER_ANGLE CONE_OUTER_ANGLE}</td><td>{@link #AL_PITCH PITCH}</td><td>{@link #AL_DIRECTION DIRECTION}</td><td>{@link #AL_LOOPING LOOPING}</td><td>{@link #AL_BUFFER BUFFER}</td><td>{@link #AL_SOURCE_STATE SOURCE_STATE}</td></tr><tr><td>{@link #AL_CONE_OUTER_GAIN CONE_OUTER_GAIN}</td><td>{@link #AL_SOURCE_TYPE SOURCE_TYPE}</td><td>{@link #AL_POSITION POSITION}</td><td>{@link #AL_VELOCITY VELOCITY}</td><td>{@link #AL_GAIN GAIN}</td><td>{@link #AL_REFERENCE_DISTANCE REFERENCE_DISTANCE}</td><td>{@link #AL_ROLLOFF_FACTOR ROLLOFF_FACTOR}</td></tr><tr><td>{@link #AL_MAX_DISTANCE MAX_DISTANCE}</td></tr></table>
     * @param value1 the first parameter value.
     * @param value2 the second parameter value.
     * @param value3 the third parameter value.
     */
    void alSource3f(int source, int param, float value1, float value2, float value3);

    /**
     * Returns the integer value of the specified source parameter.
     *
     * @param source the source to query.
     * @param param  the parameter to query. One of:<br><table><tr><td>{@link #AL_CONE_INNER_ANGLE CONE_INNER_ANGLE}</td><td>{@link #AL_CONE_OUTER_ANGLE CONE_OUTER_ANGLE}</td><td>{@link #AL_PITCH PITCH}</td><td>{@link #AL_DIRECTION DIRECTION}</td><td>{@link #AL_LOOPING LOOPING}</td><td>{@link #AL_BUFFER BUFFER}</td><td>{@link #AL_SOURCE_STATE SOURCE_STATE}</td></tr><tr><td>{@link #AL_CONE_OUTER_GAIN CONE_OUTER_GAIN}</td><td>{@link #AL_SOURCE_TYPE SOURCE_TYPE}</td><td>{@link #AL_POSITION POSITION}</td><td>{@link #AL_VELOCITY VELOCITY}</td><td>{@link #AL_GAIN GAIN}</td><td>{@link #AL_REFERENCE_DISTANCE REFERENCE_DISTANCE}</td><td>{@link #AL_ROLLOFF_FACTOR ROLLOFF_FACTOR}</td></tr><tr><td>{@link #AL_MAX_DISTANCE MAX_DISTANCE}</td></tr></table>
     */
    int alGetSourcei(int source, int param);

    /**
     * Removes a number of buffer entries that have finished processing, in the order of apperance, from the queue of the specified source.
     * <p>
     * <p>Once a queue entry for a buffer has been appended to a queue and is pending processing, it should not be changed. Removal of a given queue entry is not
     * possible unless either the source is stopped (in which case then entire queue is considered processed), or if the queue entry has already been processed
     * (AL_PLAYING or AL_PAUSED source). A playing source will enter the AL_STOPPED state if it completes playback of the last buffer in its queue (the same
     * behavior as when a single buffer has been attached to a source and has finished playback).</p>
     *
     * @param source     the target source
     * @param numBuffers the names count.
     * @param buffers    the buffer names
     */
    void alSourceUnqueueBuffers(int source, int numBuffers, IntBuffer buffers);

    /**
     * Queues up one or multiple buffer names to the specified source.
     * <p>
     * <p>The buffers will be queued in the sequence in which they appear in the array. This command is legal on a source in any playback state (to allow for
     * streaming, queuing has to be possible on a AL_PLAYING source). All buffers in a queue must have the same format and attributes, with the exception of
     * the {@code NULL} buffer (i.e., 0) which can always be queued.</p>
     *
     * @param source     the target source.
     * @param numBuffers the names count.
     * @param buffers    the buffer names.
     */
    void alSourceQueueBuffers(int source, int numBuffers, IntBuffer buffers);

    /**
     * Pointer version of {@link #alListenerf Listenerf}.
     *
     * @param param the parameter to modify.
     * @param data  the parameter values.
     */
    void alListener(int param, FloatBuffer data);

    /**
     * Sets the float value of a listener parameter.
     *
     * @param param the parameter to modify. One of:<br><table><tr><td>{@link #AL_ORIENTATION ORIENTATION}</td><td>{@link #AL_POSITION POSITION}</td><td>{@link #AL_VELOCITY VELOCITY}</td><td>{@link #AL_GAIN GAIN}</td></tr></table>
     * @param value the parameter value.
     */
    void alListenerf(int param, float value);

    /**
     * Sets the 3 dimensional float values of a listener parameter.
     *
     * @param param  the parameter to modify. One of:<br><table><tr><td>{@link #AL_ORIENTATION ORIENTATION}</td><td>{@link #AL_POSITION POSITION}</td><td>{@link #AL_VELOCITY VELOCITY}</td><td>{@link #AL_GAIN GAIN}</td></tr></table>
     * @param value1 the first value.
     * @param value2 the second value.
     * @param value3 the third value.
     */
    void alListener3f(int param, float value1, float value2, float value3);

    /**
     * Sets the 3 dimensional integer values of a source parameter.
     *
     * @param source the source to modify.
     * @param param  the parameter to modify.
     * @param value1 the first value.
     * @param value2 the second value.
     * @param value3 the third value.
     */
    void alSource3i(int source, int param, int value1, int value2, int value3);
}
