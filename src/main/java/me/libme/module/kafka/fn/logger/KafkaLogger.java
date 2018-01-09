package me.libme.module.kafka.fn.logger;

import me.libme.module.kafka.SimpleProducer;
import org.slf4j.Logger;
import org.slf4j.Marker;

import java.util.List;

public class KafkaLogger implements Logger {

	String className;

	Class<?> clazz;

	SimpleProducer producer;

	KafkaLoggerTopicMatch kafkaLoggerTopicMatch;

	private void send(String msg,LoggerType loggerType,Throwable throwable){

		List<String> topics= kafkaLoggerTopicMatch.matches(loggerType);

		topics.forEach(topic->{
			producer.send(msg,topic);
		});

	}


	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean isTraceEnabled() {
		return false;
	}

	@Override
	public void trace(String msg) {

	}

	@Override
	public void trace(String format, Object arg) {

	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {

	}

	@Override
	public void trace(String format, Object... arguments) {

	}

	@Override
	public void trace(String msg, Throwable t) {

	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return false;
	}

	@Override
	public void trace(Marker marker, String msg) {

	}

	@Override
	public void trace(Marker marker, String format, Object arg) {

	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {

	}

	@Override
	public void trace(Marker marker, String format, Object... argArray) {

	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {

	}

	@Override
	public boolean isDebugEnabled() {
		return false;
	}

	@Override
	public void debug(String msg) {

		send(msg,LoggerType.DEBUG,null);

	}

	@Override
	public void debug(String format, Object arg) {

	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {

	}

	@Override
	public void debug(String format, Object... arguments) {

	}

	@Override
	public void debug(String msg, Throwable t) {
		send(msg,LoggerType.DEBUG,t);
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return false;
	}

	@Override
	public void debug(Marker marker, String msg) {

	}

	@Override
	public void debug(Marker marker, String format, Object arg) {

	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {

	}

	@Override
	public void debug(Marker marker, String format, Object... arguments) {

	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {

	}

	@Override
	public boolean isInfoEnabled() {
		return false;
	}

	@Override
	public void info(String msg) {
		send(msg,LoggerType.INFO,null);
	}

	@Override
	public void info(String format, Object arg) {

	}

	@Override
	public void info(String format, Object arg1, Object arg2) {

	}

	@Override
	public void info(String format, Object... arguments) {

	}

	@Override
	public void info(String msg, Throwable t) {
		send(msg,LoggerType.INFO,t);
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return false;
	}

	@Override
	public void info(Marker marker, String msg) {

	}

	@Override
	public void info(Marker marker, String format, Object arg) {

	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {

	}

	@Override
	public void info(Marker marker, String format, Object... arguments) {

	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {

	}

	@Override
	public boolean isWarnEnabled() {
		return false;
	}

	@Override
	public void warn(String msg) {
		send(msg,LoggerType.WARNING,null);
	}

	@Override
	public void warn(String format, Object arg) {

	}

	@Override
	public void warn(String format, Object... arguments) {

	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {

	}

	@Override
	public void warn(String msg, Throwable t) {
		send(msg,LoggerType.WARNING,t);
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return false;
	}

	@Override
	public void warn(Marker marker, String msg) {

	}

	@Override
	public void warn(Marker marker, String format, Object arg) {

	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {

	}

	@Override
	public void warn(Marker marker, String format, Object... arguments) {

	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {

	}

	@Override
	public boolean isErrorEnabled() {
		return false;
	}

	@Override
	public void error(String msg) {
		send(msg,LoggerType.ERROR,null);
	}

	@Override
	public void error(String format, Object arg) {

	}

	@Override
	public void error(String format, Object arg1, Object arg2) {

	}

	@Override
	public void error(String format, Object... arguments) {

	}

	@Override
	public void error(String msg, Throwable t) {
		send(msg,LoggerType.ERROR,t);
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return false;
	}

	@Override
	public void error(Marker marker, String msg) {

	}

	@Override
	public void error(Marker marker, String format, Object arg) {

	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {

	}

	@Override
	public void error(Marker marker, String format, Object... arguments) {

	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {

	}



}
