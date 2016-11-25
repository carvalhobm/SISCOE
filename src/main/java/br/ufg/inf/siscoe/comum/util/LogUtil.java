package br.ufg.inf.siscoe.comum.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogUtil {
    public static boolean enabledLogDebug = false;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    /**
     * <p>
     * M�todo respons�vel por imprimir a mensagem no log do servidor.
     * <p>
     *
     * @param mensagem
     *            valor a ser atribuido
     */
    public static void imprimirLog(final String siglaSistema, final String mensagem) {
        System.out.println("[" + siglaSistema + "]" + LogUtil.sdf.format(new Date()) + mensagem);
    }

    /**
     * <p>
     * M�todo respons�vel por imprimir log de Debug.
     * <p>
     *
     * @param object
     *            valor a ser atribuido
     */
    public static void debug(final Object object) {
        final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        final int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        final Log logger = LogFactory.getLog(Thread.currentThread().getStackTrace()[2].getClassName());
        logger.debug(methodName + ":" + line + " " + object);
        if (enabledLogDebug) {
            logger.info("###-DEBUG-### " + methodName + ":" + line + " ### " + object);
        }
    }

    /**
     * <p>
     * M�todo respons�vel por imprimir log informativo.
     * <p>
     *
     * @param object
     *            valor a ser atribuido
     */
    public static void info(final Object object) {
        final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        final int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        final Log logger = LogFactory.getLog(Thread.currentThread().getStackTrace()[2].getClassName());
        logger.info(methodName + ":" + line + " ### " + object);
    }

    /**
     * <p>
     * M�todo respons�vel por imprimir log com erro.
     * <p>
     *
     * @param object
     *            valor a ser atribuido
     */
    public static void error(final Object object) {
        final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        final int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        final Log logger = LogFactory.getLog(Thread.currentThread().getStackTrace()[2].getClassName());
        logger.error(methodName + ":" + line + " ### " + object);
    }

    /**
     * <p>
     * M�todo respons�vel por imprimir log com erro Fatal.
     * <p>
     *
     * @param object
     *            valor a ser atribuido
     */
    public static void fatal(final Object object) {
        final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        final int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        final Log logger = LogFactory.getLog(Thread.currentThread().getStackTrace()[2].getClassName());
        logger.fatal(methodName + ":" + line + " ### " + object);
    }

    /**
     * <p>
     * M�todo respons�vel por imprimir log de Alerta.
     * <p>
     *
     * @param object
     *            valor a ser atribuido
     */
    public static void warn(final Object object) {
        final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        final int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        final Log logger = LogFactory.getLog(Thread.currentThread().getStackTrace()[2].getClassName());
        logger.warn(methodName + ":" + line + " ### " + object);
    }
}
