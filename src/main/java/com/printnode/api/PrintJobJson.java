package com.printnode.api;

/**
 * An object to be serialized into JSON for creating printjobs.
 * */
public class PrintJobJson {
    /**
     * The id of the printer we're printing on.
     * */
    private int printerId;
    /**
     * The title of the PrintJob.
     * */
    private String title;
    /**
     * The type of content we are using.
     * */
    private String contentType;
    /**
     * If content-type xxx_base64:
     * This is the base64 string you want to upload.
     * If content-type xxx_uri:
     * This is a URL to the file you want printed.
     * */
    private String content;
    /**
     * Source of the PrintJob.
     * */
    private String source;
    /**
     * Options to be set on this PrintJob.
     * Add these via PrintJobJson.getOptions.set(option)..
     * */
    private Options options;
    /**
     * Set time to expire on this PrintJob.
     * */
    private int expireAfter = -1;
    /**
     * How many times you want to send this PrintJob.
     * */
    private int qty = 1;

    /**
     * Creates an object to be serialized into JSON.
     *
     * @param newPrinterId id of the printer which wil run the PrintJob.
     * @param newTitle title of the PrintJob.
     * @param newContentType Type of content. base64, uri, etc.
     * @param newContent either base64 string, or a URL to a file. Depends on contentType.
     * @param newSource Would be from the PrintNode-Java client.
     * */
    public PrintJobJson(final int newPrinterId,
            final String newTitle,
            final String newContentType,
            final String newContent,
            final String newSource) {
        printerId = newPrinterId;
        title = newTitle;
        contentType = newContentType;
        content = newContent;
        source = newSource;
        options = new Options();
    }

    /**
     * @return Options object of this PrintJob.
     * */
    public final Options getOptions() {
        return options;
    }

    /**
     * @param newExpireAfter set the timeout for this PrintJob.
     * */
    public final void setExpireAfter(final int newExpireAfter) {
        expireAfter = newExpireAfter;
    }

    /**
     * @param newQty set the number of times this PrintJob is sent to the queue.
     * */
    public final void setQty(final int newQty) {
        qty = newQty;
    }

}
