// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package formation_s25.error_log_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

//the import part of tJava_1
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: error_log Purpose: mettre en place la gestion d'erreur<br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class error_log implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (db_in_AdditionalParams != null) {

				this.setProperty("db_in_AdditionalParams", db_in_AdditionalParams.toString());

			}

			if (db_in_Password != null) {

				this.setProperty("db_in_Password", db_in_Password.toString());

			}

			if (db_in_Server != null) {

				this.setProperty("db_in_Server", db_in_Server.toString());

			}

			if (db_in_Port != null) {

				this.setProperty("db_in_Port", db_in_Port.toString());

			}

			if (db_in_Login != null) {

				this.setProperty("db_in_Login", db_in_Login.toString());

			}

			if (db_in_Database != null) {

				this.setProperty("db_in_Database", db_in_Database.toString());

			}

			if (api_url != null) {

				this.setProperty("api_url", api_url.toString());

			}

			if (nb_cpus != null) {

				this.setProperty("nb_cpus", nb_cpus.toString());

			}

			if (data_dir != null) {

				this.setProperty("data_dir", data_dir.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String db_in_AdditionalParams;

		public String getDb_in_AdditionalParams() {
			return this.db_in_AdditionalParams;
		}

		public java.lang.String db_in_Password;

		public java.lang.String getDb_in_Password() {
			return this.db_in_Password;
		}

		public String db_in_Server;

		public String getDb_in_Server() {
			return this.db_in_Server;
		}

		public String db_in_Port;

		public String getDb_in_Port() {
			return this.db_in_Port;
		}

		public String db_in_Login;

		public String getDb_in_Login() {
			return this.db_in_Login;
		}

		public String db_in_Database;

		public String getDb_in_Database() {
			return this.db_in_Database;
		}

		public String api_url;

		public String getApi_url() {
			return this.api_url;
		}

		public Integer nb_cpus;

		public Integer getNb_cpus() {
			return this.nb_cpus;
		}

		public String data_dir;

		public String getData_dir() {
			return this.data_dir;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "error_log";
	private final String projectName = "FORMATION_S25";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	LogCatcherUtils tLogCatcher_1 = new LogCatcherUtils();
	LogCatcherUtils tLogCatcher_2 = new LogCatcherUtils();

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					error_log.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(error_log.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						tLogCatcher_1.addMessage("Java Exception", currentComponent, 6,
								e.getClass().getName() + ":" + e.getMessage(), 1);
						tLogCatcher_1Process(globalMap);
					}
				} catch (TalendException e) {
					// do nothing

				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUniqRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tWarn_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputXML_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogCatcher_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSetGlobalVar_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tSetGlobalVar_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogCatcher_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPostjob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tJava_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSendMail_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tSendMail_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSetGlobalVar_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tSetGlobalVar_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tLogCatcher_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tSetGlobalVar_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tLogCatcher_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPostjob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tJava_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tSendMail_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPrejob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tSetGlobalVar_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_error_log = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_error_log = new byte[0];

		public Boolean no_pets;

		public Boolean getNo_pets() {
			return this.no_pets;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.no_pets = null;
					} else {
						this.no_pets = dis.readBoolean();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.no_pets = null;
					} else {
						this.no_pets = dis.readBoolean();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Boolean

				if (this.no_pets == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.no_pets);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Boolean

				if (this.no_pets == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.no_pets);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("no_pets=" + String.valueOf(no_pets));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class ErrorRejectStruct implements routines.system.IPersistableRow<ErrorRejectStruct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_error_log = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_error_log = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public java.util.Date date;

		public java.util.Date getDate() {
			return this.date;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String component;

		public String getComponent() {
			return this.component;
		}

		public String errorMessage;

		public String getErrorMessage() {
			return this.errorMessage;
		}

		public String errorStackTrace;

		public String getErrorStackTrace() {
			return this.errorStackTrace;
		}

		public String infos;

		public String getInfos() {
			return this.infos;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.infos == null) ? 0 : this.infos.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final ErrorRejectStruct other = (ErrorRejectStruct) obj;

			if (this.infos == null) {
				if (other.infos != null)
					return false;

			} else if (!this.infos.equals(other.infos))

				return false;

			return true;
		}

		public void copyDataTo(ErrorRejectStruct other) {

			other.date = this.date;
			other.project = this.project;
			other.job = this.job;
			other.component = this.component;
			other.errorMessage = this.errorMessage;
			other.errorStackTrace = this.errorStackTrace;
			other.infos = this.infos;

		}

		public void copyKeysDataTo(ErrorRejectStruct other) {

			other.infos = this.infos;

		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.date = readDate(dis);

					this.project = readString(dis);

					this.job = readString(dis);

					this.component = readString(dis);

					this.errorMessage = readString(dis);

					this.errorStackTrace = readString(dis);

					this.infos = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.date = readDate(dis);

					this.project = readString(dis);

					this.job = readString(dis);

					this.component = readString(dis);

					this.errorMessage = readString(dis);

					this.errorStackTrace = readString(dis);

					this.infos = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// java.util.Date

				writeDate(this.date, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.component, dos);

				// String

				writeString(this.errorMessage, dos);

				// String

				writeString(this.errorStackTrace, dos);

				// String

				writeString(this.infos, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// java.util.Date

				writeDate(this.date, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.component, dos);

				// String

				writeString(this.errorMessage, dos);

				// String

				writeString(this.errorStackTrace, dos);

				// String

				writeString(this.infos, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("date=" + String.valueOf(date));
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",component=" + component);
			sb.append(",errorMessage=" + errorMessage);
			sb.append(",errorStackTrace=" + errorStackTrace);
			sb.append(",infos=" + infos);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(ErrorRejectStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.infos, other.infos);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class owner_petsStruct implements routines.system.IPersistableRow<owner_petsStruct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_error_log = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_error_log = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public long co_id;

		public long getCo_id() {
			return this.co_id;
		}

		public String owner_name;

		public String getOwner_name() {
			return this.owner_name;
		}

		public String name;

		public String getName() {
			return this.name;
		}

		public Integer age;

		public Integer getAge() {
			return this.age;
		}

		public String color;

		public String getColor() {
			return this.color;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.co_id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final owner_petsStruct other = (owner_petsStruct) obj;

			if (this.co_id != other.co_id)
				return false;

			return true;
		}

		public void copyDataTo(owner_petsStruct other) {

			other.co_id = this.co_id;
			other.owner_name = this.owner_name;
			other.name = this.name;
			other.age = this.age;
			other.color = this.color;

		}

		public void copyKeysDataTo(owner_petsStruct other) {

			other.co_id = this.co_id;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.co_id = dis.readLong();

					this.owner_name = readString(dis);

					this.name = readString(dis);

					this.age = readInteger(dis);

					this.color = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.co_id = dis.readLong();

					this.owner_name = readString(dis);

					this.name = readString(dis);

					this.age = readInteger(dis);

					this.color = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// long

				dos.writeLong(this.co_id);

				// String

				writeString(this.owner_name, dos);

				// String

				writeString(this.name, dos);

				// Integer

				writeInteger(this.age, dos);

				// String

				writeString(this.color, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// long

				dos.writeLong(this.co_id);

				// String

				writeString(this.owner_name, dos);

				// String

				writeString(this.name, dos);

				// Integer

				writeInteger(this.age, dos);

				// String

				writeString(this.color, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("co_id=" + String.valueOf(co_id));
			sb.append(",owner_name=" + owner_name);
			sb.append(",name=" + name);
			sb.append(",age=" + String.valueOf(age));
			sb.append(",color=" + color);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(owner_petsStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.co_id, other.co_id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class owner_wo_petsStruct implements routines.system.IPersistableRow<owner_wo_petsStruct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_error_log = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_error_log = new byte[0];

		public Boolean no_pets;

		public Boolean getNo_pets() {
			return this.no_pets;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.no_pets = null;
					} else {
						this.no_pets = dis.readBoolean();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					length = dis.readByte();
					if (length == -1) {
						this.no_pets = null;
					} else {
						this.no_pets = dis.readBoolean();
					}

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Boolean

				if (this.no_pets == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.no_pets);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Boolean

				if (this.no_pets == null) {
					dos.writeByte(-1);
				} else {
					dos.writeByte(0);
					dos.writeBoolean(this.no_pets);
				}

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("no_pets=" + String.valueOf(no_pets));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(owner_wo_petsStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_error_log = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_error_log = new byte[0];

		public long co_id;

		public long getCo_id() {
			return this.co_id;
		}

		public String co_name;

		public String getCo_name() {
			return this.co_name;
		}

		public String co_firstname;

		public String getCo_firstname() {
			return this.co_firstname;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.co_id = dis.readLong();

					this.co_name = readString(dis);

					this.co_firstname = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.co_id = dis.readLong();

					this.co_name = readString(dis);

					this.co_firstname = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// long

				dos.writeLong(this.co_id);

				// String

				writeString(this.co_name, dos);

				// String

				writeString(this.co_firstname, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// long

				dos.writeLong(this.co_id);

				// String

				writeString(this.co_name, dos);

				// String

				writeString(this.co_firstname, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("co_id=" + String.valueOf(co_id));
			sb.append(",co_name=" + co_name);
			sb.append(",co_firstname=" + co_firstname);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_error_log = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_error_log = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public long co_id;

		public long getCo_id() {
			return this.co_id;
		}

		public String co_name;

		public String getCo_name() {
			return this.co_name;
		}

		public String co_firstname;

		public String getCo_firstname() {
			return this.co_firstname;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.co_id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;

			if (this.co_id != other.co_id)
				return false;

			return true;
		}

		public void copyDataTo(after_tDBInput_1Struct other) {

			other.co_id = this.co_id;
			other.co_name = this.co_name;
			other.co_firstname = this.co_firstname;

		}

		public void copyKeysDataTo(after_tDBInput_1Struct other) {

			other.co_id = this.co_id;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.co_id = dis.readLong();

					this.co_name = readString(dis);

					this.co_firstname = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.co_id = dis.readLong();

					this.co_name = readString(dis);

					this.co_firstname = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// long

				dos.writeLong(this.co_id);

				// String

				writeString(this.co_name, dos);

				// String

				writeString(this.co_firstname, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// long

				dos.writeLong(this.co_id);

				// String

				writeString(this.co_name, dos);

				// String

				writeString(this.co_firstname, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("co_id=" + String.valueOf(co_id));
			sb.append(",co_name=" + co_name);
			sb.append(",co_firstname=" + co_firstname);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.co_id, other.co_id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tFileInputXML_1Process(globalMap);

				row1Struct row1 = new row1Struct();
				ErrorRejectStruct ErrorReject = new ErrorRejectStruct();
				owner_petsStruct owner_pets = new owner_petsStruct();
				owner_wo_petsStruct owner_wo_pets = new owner_wo_petsStruct();
				row5Struct row5 = new row5Struct();

				/**
				 * [tFileOutputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_1", false);
				start_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "ErrorReject");
				}

				int tos_count_tFileOutputDelimited_1 = 0;

				String fileName_tFileOutputDelimited_1 = "";
				fileName_tFileOutputDelimited_1 = (new java.io.File(context.data_dir + "error.log")).getAbsolutePath()
						.replace("\\", "/");
				String fullName_tFileOutputDelimited_1 = null;
				String extension_tFileOutputDelimited_1 = null;
				String directory_tFileOutputDelimited_1 = null;
				if ((fileName_tFileOutputDelimited_1.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_1.lastIndexOf(".") < fileName_tFileOutputDelimited_1
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
						extension_tFileOutputDelimited_1 = "";
					} else {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0,
								fileName_tFileOutputDelimited_1.lastIndexOf("."));
						extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0,
							fileName_tFileOutputDelimited_1.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_1.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0,
								fileName_tFileOutputDelimited_1.lastIndexOf("."));
						extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
						extension_tFileOutputDelimited_1 = "";
					}
					directory_tFileOutputDelimited_1 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_1 = true;
				java.io.File filetFileOutputDelimited_1 = new java.io.File(fileName_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME", fileName_tFileOutputDelimited_1);
				if (filetFileOutputDelimited_1.exists()) {
					isFileGenerated_tFileOutputDelimited_1 = false;
				}
				int nb_line_tFileOutputDelimited_1 = 0;
				int splitedFileNo_tFileOutputDelimited_1 = 0;
				int currentRow_tFileOutputDelimited_1 = 0;

				final String OUT_DELIM_tFileOutputDelimited_1 = /** Start field tFileOutputDelimited_1:FIELDSEPARATOR */
						";"/** End field tFileOutputDelimited_1:FIELDSEPARATOR */
				;

				final String OUT_DELIM_ROWSEP_tFileOutputDelimited_1 = /**
																		 * Start field
																		 * tFileOutputDelimited_1:ROWSEPARATOR
																		 */
						"\n"/** End field tFileOutputDelimited_1:ROWSEPARATOR */
				;

				// create directory only if not exists
				if (directory_tFileOutputDelimited_1 != null && directory_tFileOutputDelimited_1.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_1 = new java.io.File(directory_tFileOutputDelimited_1);
					if (!dir_tFileOutputDelimited_1.exists()) {
						dir_tFileOutputDelimited_1.mkdirs();
					}
				}

				// routines.system.Row
				java.io.Writer outtFileOutputDelimited_1 = null;

				outtFileOutputDelimited_1 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
						new java.io.FileOutputStream(fileName_tFileOutputDelimited_1, true), "ISO-8859-15"));
				if (filetFileOutputDelimited_1.length() == 0) {
					outtFileOutputDelimited_1.write("date");
					outtFileOutputDelimited_1.write(OUT_DELIM_tFileOutputDelimited_1);
					outtFileOutputDelimited_1.write("project");
					outtFileOutputDelimited_1.write(OUT_DELIM_tFileOutputDelimited_1);
					outtFileOutputDelimited_1.write("job");
					outtFileOutputDelimited_1.write(OUT_DELIM_tFileOutputDelimited_1);
					outtFileOutputDelimited_1.write("component");
					outtFileOutputDelimited_1.write(OUT_DELIM_tFileOutputDelimited_1);
					outtFileOutputDelimited_1.write("errorMessage");
					outtFileOutputDelimited_1.write(OUT_DELIM_tFileOutputDelimited_1);
					outtFileOutputDelimited_1.write("errorStackTrace");
					outtFileOutputDelimited_1.write(OUT_DELIM_tFileOutputDelimited_1);
					outtFileOutputDelimited_1.write("infos");
					outtFileOutputDelimited_1.write(OUT_DELIM_ROWSEP_tFileOutputDelimited_1);
					outtFileOutputDelimited_1.flush();
				}

				resourceMap.put("out_tFileOutputDelimited_1", outtFileOutputDelimited_1);
				resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

				/**
				 * [tFileOutputDelimited_1 begin ] stop
				 */

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "owner_pets");
				}

				int tos_count_tLogRow_1 = 0;

				///////////////////////

				class Util_tLogRow_1 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[5];

					public void addRow(String[] row) {

						for (int i = 0; i < 5; i++) {
							if (row[i] != null) {
								colLengths[i] = Math.max(colLengths[i], row[i].length());
							}
						}
						list.add(row);
					}

					public void setTableName(String name) {

						this.name = name;
					}

					public StringBuilder format() {

						StringBuilder sb = new StringBuilder();

						sb.append(print(des_top));

						int totals = 0;
						for (int i = 0; i < colLengths.length; i++) {
							totals = totals + colLengths[i];
						}

						// name
						sb.append("|");
						int k = 0;
						for (k = 0; k < (totals + 4 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 4 - name.length() - k; i++) {
							sb.append(' ');
						}
						sb.append("|\n");

						// head and rows
						sb.append(print(des_head));
						for (int i = 0; i < list.size(); i++) {

							String[] row = list.get(i);

							java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());

							StringBuilder sbformat = new StringBuilder();
							sbformat.append("|%1$-");
							sbformat.append(colLengths[0]);
							sbformat.append("s");

							sbformat.append("|%2$-");
							sbformat.append(colLengths[1]);
							sbformat.append("s");

							sbformat.append("|%3$-");
							sbformat.append(colLengths[2]);
							sbformat.append("s");

							sbformat.append("|%4$-");
							sbformat.append(colLengths[3]);
							sbformat.append("s");

							sbformat.append("|%5$-");
							sbformat.append(colLengths[4]);
							sbformat.append("s");

							sbformat.append("|\n");

							formatter.format(sbformat.toString(), (Object[]) row);

							sb.append(formatter.toString());
							if (i == 0)
								sb.append(print(des_head)); // print the head
						}

						// end
						sb.append(print(des_bottom));
						return sb;
					}

					private StringBuilder print(String[] fillChars) {
						StringBuilder sb = new StringBuilder();
						// first column
						sb.append(fillChars[0]);
						for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[3] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						// last column
						for (int i = 0; i < colLengths[4] - fillChars[1].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[1]);
						sb.append("\n");
						return sb;
					}

					public boolean isTableEmpty() {
						if (list.size() > 1)
							return false;
						return true;
					}
				}
				Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
				util_tLogRow_1.setTableName("tLogRow_1");
				util_tLogRow_1.addRow(new String[] { "co_id", "owner_name", "name", "age", "color", });
				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tWarn_1 begin ] start
				 */

				ok_Hash.put("tWarn_1", false);
				start_Hash.put("tWarn_1", System.currentTimeMillis());

				currentComponent = "tWarn_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tWarn_1 = 0;

				/**
				 * [tWarn_1 begin ] stop
				 */

				/**
				 * [tUniqRow_1 begin ] start
				 */

				ok_Hash.put("tUniqRow_1", false);
				start_Hash.put("tUniqRow_1", System.currentTimeMillis());

				currentComponent = "tUniqRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "owner_wo_pets");
				}

				int tos_count_tUniqRow_1 = 0;

				class KeyStruct_tUniqRow_1 {

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					Boolean no_pets;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + ((this.no_pets == null) ? 0 : this.no_pets.hashCode());

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;

						if (this.no_pets == null) {
							if (other.no_pets != null)
								return false;

						} else if (!this.no_pets.equals(other.no_pets))

							return false;

						return true;
					}

				}

				int nb_uniques_tUniqRow_1 = 0;
				int nb_duplicates_tUniqRow_1 = 0;
				KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
				java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>();

				/**
				 * [tUniqRow_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				ErrorRejectStruct ErrorReject_tmp = new ErrorRejectStruct();
				owner_petsStruct owner_pets_tmp = new owner_petsStruct();
				owner_wo_petsStruct owner_wo_pets_tmp = new owner_wo_petsStruct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
				calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
				java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "org.mariadb.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = context.db_in_Login;

				final String decryptedPassword_tDBInput_1 = context.db_in_Password;

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String properties_tDBInput_1 = context.db_in_AdditionalParams;
				if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
					properties_tDBInput_1 = "";
				}
				String url_tDBInput_1 = "jdbc:mariadb://" + context.db_in_Server + ":" + context.db_in_Port + "/"
						+ context.db_in_Database + "?" + properties_tDBInput_1;

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT \n  `contact`.`co_id`, \n  `contact`.`co_name`, \n  `contact`.`co_firstname`\nFROM `contact`";

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.co_id = 0;
						} else {

							row1.co_id = rs_tDBInput_1.getLong(1);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.co_name = null;
						} else {

							row1.co_name = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.co_firstname = null;
						} else {

							row1.co_firstname = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
						}

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						///////////////////////////////////////////////
						// Starting Lookup Table "row2"
						///////////////////////////////////////////////

						boolean forceLooprow2 = false;

						row2Struct row2ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row2HashKey.contact = routines.system.TypeConvert.Long2Integer(row1.co_id);

							row2HashKey.hashCodeDirty = true;

							tHash_Lookup_row2.lookup(row2HashKey);

							if (!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

								rejectedInnerJoin_tMap_1 = true;

								forceLooprow2 = true;

							} // G_TM_M_090

						} // G_TM_M_020

						else { // G 20 - G 21
							forceLooprow2 = true;
						} // G 21

						row2Struct row2 = null;

						while ((tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) || forceLooprow2) { // G_TM_M_043

							// CALL close loop of lookup 'row2'

							row2Struct fromLookup_row2 = null;
							row2 = row2Default;

							if (!forceLooprow2) { // G 46

								fromLookup_row2 = tHash_Lookup_row2.next();

								if (fromLookup_row2 != null) {
									row2 = fromLookup_row2;
								}

							} // G 46

							forceLooprow2 = false;

							try {// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
									// ###############################
									// # Output tables

									ErrorReject = null;
									owner_pets = null;
									owner_wo_pets = null;

									if (!rejectedInnerJoin_tMap_1) {

// # Output table : 'owner_pets'
										owner_pets_tmp.co_id = row1.co_id;
										owner_pets_tmp.owner_name = row1.co_firstname + " " + row1.co_name;
										owner_pets_tmp.name = row2.name;
										owner_pets_tmp.age = row2.age;
										owner_pets_tmp.color = row2.color;
										owner_pets = owner_pets_tmp;
									} // closing inner join bracket (1)
// ###### START REJECTS ##### 

// # Output reject table : 'owner_wo_pets'
// # Filter conditions 
									if (rejectedInnerJoin_tMap_1) {
										owner_wo_pets_tmp.no_pets = true;
										owner_wo_pets = owner_wo_pets_tmp;
									} // closing filter/reject
// ###############################

								} // end of Var scope

								rejectedInnerJoin_tMap_1 = false;

							} catch (java.lang.Exception e) {
								// if anohter java.lang.Exception when processing an java.lang.Exception

								try {// EE
									Var__tMap_1__Struct Var = Var__tMap_1;

									ErrorReject_tmp.date = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss",
											TalendDate.getDate("yyyy-MM-dd HH:mm:ss"));
									ErrorReject_tmp.project = projectName;
									ErrorReject_tmp.job = jobName;
									ErrorReject_tmp.component = "tMap_1";
									ErrorReject_tmp.infos = "infos: " + row1.co_id + ":" + row1.co_name;
									ErrorReject = ErrorReject_tmp;
									ErrorReject.errorMessage = e.getMessage();
									ErrorReject.errorStackTrace = ResumeUtil.getExceptionStackTrace(e);

									owner_pets = null;
									owner_wo_pets = null;
								} catch (java.lang.Exception ee) {// EE

									ee.printStackTrace();
									owner_pets = null;
									owner_wo_pets = null;
								} // EE
							} // end catch

							tos_count_tMap_1++;

							/**
							 * [tMap_1 main ] stop
							 */

							/**
							 * [tMap_1 process_data_begin ] start
							 */

							currentComponent = "tMap_1";

							/**
							 * [tMap_1 process_data_begin ] stop
							 */
// Start of branch "ErrorReject"
							if (ErrorReject != null) {

								/**
								 * [tFileOutputDelimited_1 main ] start
								 */

								currentComponent = "tFileOutputDelimited_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "ErrorReject"

									);
								}

								StringBuilder sb_tFileOutputDelimited_1 = new StringBuilder();
								if (ErrorReject.date != null) {
									sb_tFileOutputDelimited_1.append(
											FormatterUtils.format_Date(ErrorReject.date, "yyyy-MM-dd HH:mm:ss"));
								}
								sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
								if (ErrorReject.project != null) {
									sb_tFileOutputDelimited_1.append(ErrorReject.project);
								}
								sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
								if (ErrorReject.job != null) {
									sb_tFileOutputDelimited_1.append(ErrorReject.job);
								}
								sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
								if (ErrorReject.component != null) {
									sb_tFileOutputDelimited_1.append(ErrorReject.component);
								}
								sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
								if (ErrorReject.errorMessage != null) {
									sb_tFileOutputDelimited_1.append(ErrorReject.errorMessage);
								}
								sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
								if (ErrorReject.errorStackTrace != null) {
									sb_tFileOutputDelimited_1.append(ErrorReject.errorStackTrace);
								}
								sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
								if (ErrorReject.infos != null) {
									sb_tFileOutputDelimited_1.append(ErrorReject.infos);
								}
								sb_tFileOutputDelimited_1.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_1);

								nb_line_tFileOutputDelimited_1++;
								resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

								outtFileOutputDelimited_1.write(sb_tFileOutputDelimited_1.toString());

								tos_count_tFileOutputDelimited_1++;

								/**
								 * [tFileOutputDelimited_1 main ] stop
								 */

								/**
								 * [tFileOutputDelimited_1 process_data_begin ] start
								 */

								currentComponent = "tFileOutputDelimited_1";

								/**
								 * [tFileOutputDelimited_1 process_data_begin ] stop
								 */

								/**
								 * [tFileOutputDelimited_1 process_data_end ] start
								 */

								currentComponent = "tFileOutputDelimited_1";

								/**
								 * [tFileOutputDelimited_1 process_data_end ] stop
								 */

							} // End of branch "ErrorReject"

// Start of branch "owner_pets"
							if (owner_pets != null) {

								/**
								 * [tLogRow_1 main ] start
								 */

								currentComponent = "tLogRow_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "owner_pets"

									);
								}

///////////////////////		

								String[] row_tLogRow_1 = new String[5];

								row_tLogRow_1[0] = String.valueOf(owner_pets.co_id);

								if (owner_pets.owner_name != null) { //
									row_tLogRow_1[1] = String.valueOf(owner_pets.owner_name);

								} //

								if (owner_pets.name != null) { //
									row_tLogRow_1[2] = String.valueOf(owner_pets.name);

								} //

								if (owner_pets.age != null) { //
									row_tLogRow_1[3] = String.valueOf(owner_pets.age);

								} //

								if (owner_pets.color != null) { //
									row_tLogRow_1[4] = String.valueOf(owner_pets.color);

								} //

								util_tLogRow_1.addRow(row_tLogRow_1);
								nb_line_tLogRow_1++;
//////

//////                    

///////////////////////    			

								tos_count_tLogRow_1++;

								/**
								 * [tLogRow_1 main ] stop
								 */

								/**
								 * [tLogRow_1 process_data_begin ] start
								 */

								currentComponent = "tLogRow_1";

								/**
								 * [tLogRow_1 process_data_begin ] stop
								 */

								/**
								 * [tLogRow_1 process_data_end ] start
								 */

								currentComponent = "tLogRow_1";

								/**
								 * [tLogRow_1 process_data_end ] stop
								 */

							} // End of branch "owner_pets"

// Start of branch "owner_wo_pets"
							if (owner_wo_pets != null) {

								/**
								 * [tUniqRow_1 main ] start
								 */

								currentComponent = "tUniqRow_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "owner_wo_pets"

									);
								}

								row5 = null;
								finder_tUniqRow_1.no_pets = owner_wo_pets.no_pets;
								finder_tUniqRow_1.hashCodeDirty = true;
								if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
									KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

									new_tUniqRow_1.no_pets = owner_wo_pets.no_pets;

									keystUniqRow_1.add(new_tUniqRow_1);
									if (row5 == null) {

										row5 = new row5Struct();
									}
									row5.no_pets = owner_wo_pets.no_pets;
									nb_uniques_tUniqRow_1++;
								} else {
									nb_duplicates_tUniqRow_1++;
								}

								tos_count_tUniqRow_1++;

								/**
								 * [tUniqRow_1 main ] stop
								 */

								/**
								 * [tUniqRow_1 process_data_begin ] start
								 */

								currentComponent = "tUniqRow_1";

								/**
								 * [tUniqRow_1 process_data_begin ] stop
								 */
// Start of branch "row5"
								if (row5 != null) {

									/**
									 * [tWarn_1 main ] start
									 */

									currentComponent = "tWarn_1";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "row5"

										);
									}

									try {

										resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_1", "",
												Thread.currentThread().getId() + "", "WARN", "",
												"there are owners without pets !!!", "", "");
										tLogCatcher_2.addMessage("tWarn", "tWarn_1", 4,
												"there are owners without pets !!!", 42);
										tLogCatcher_2Process(globalMap);
										globalMap.put("tWarn_1_WARN_MESSAGES", "there are owners without pets !!!");
										globalMap.put("tWarn_1_WARN_PRIORITY", 4);
										globalMap.put("tWarn_1_WARN_CODE", 42);

									} catch (Exception e_tWarn_1) {
										globalMap.put("tWarn_1_ERROR_MESSAGE", e_tWarn_1.getMessage());
										logIgnoredError(String.format(
												"tWarn_1 - tWarn failed to log message due to internal error: %s",
												e_tWarn_1), e_tWarn_1);
									}

									tos_count_tWarn_1++;

									/**
									 * [tWarn_1 main ] stop
									 */

									/**
									 * [tWarn_1 process_data_begin ] start
									 */

									currentComponent = "tWarn_1";

									/**
									 * [tWarn_1 process_data_begin ] stop
									 */

									/**
									 * [tWarn_1 process_data_end ] start
									 */

									currentComponent = "tWarn_1";

									/**
									 * [tWarn_1 process_data_end ] stop
									 */

								} // End of branch "row5"

								/**
								 * [tUniqRow_1 process_data_end ] start
								 */

								currentComponent = "tUniqRow_1";

								/**
								 * [tUniqRow_1 process_data_end ] stop
								 */

							} // End of branch "owner_wo_pets"

						} // close loop of lookup 'row2' // G_TM_M_043

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}

				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row2 != null) {
					tHash_Lookup_row2.endGet();
				}
				globalMap.remove("tHash_Lookup_row2");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 end ] start
				 */

				currentComponent = "tFileOutputDelimited_1";

				if (outtFileOutputDelimited_1 != null) {
					outtFileOutputDelimited_1.flush();
					outtFileOutputDelimited_1.close();
				}

				globalMap.put("tFileOutputDelimited_1_NB_LINE", nb_line_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME", fileName_tFileOutputDelimited_1);

				resourceMap.put("finish_tFileOutputDelimited_1", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "ErrorReject");
				}

				ok_Hash.put("tFileOutputDelimited_1", true);
				end_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_1 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

//////

				java.io.PrintStream consoleOut_tLogRow_1 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
				}

				consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
				consoleOut_tLogRow_1.flush();
//////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);

///////////////////////    			

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "owner_pets");
				}

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
				 */

				/**
				 * [tUniqRow_1 end ] start
				 */

				currentComponent = "tUniqRow_1";

				globalMap.put("tUniqRow_1_NB_UNIQUES", nb_uniques_tUniqRow_1);
				globalMap.put("tUniqRow_1_NB_DUPLICATES", nb_duplicates_tUniqRow_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "owner_wo_pets");
				}

				ok_Hash.put("tUniqRow_1", true);
				end_Hash.put("tUniqRow_1", System.currentTimeMillis());

				/**
				 * [tUniqRow_1 end ] stop
				 */

				/**
				 * [tWarn_1 end ] start
				 */

				currentComponent = "tWarn_1";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				ok_Hash.put("tWarn_1", true);
				end_Hash.put("tWarn_1", System.currentTimeMillis());

				/**
				 * [tWarn_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row2");

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_1";

				if (resourceMap.get("finish_tFileOutputDelimited_1") == null) {

					java.io.Writer outtFileOutputDelimited_1 = (java.io.Writer) resourceMap
							.get("out_tFileOutputDelimited_1");
					if (outtFileOutputDelimited_1 != null) {
						outtFileOutputDelimited_1.flush();
						outtFileOutputDelimited_1.close();
					}

				}

				/**
				 * [tFileOutputDelimited_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

				/**
				 * [tUniqRow_1 finally ] start
				 */

				currentComponent = "tUniqRow_1";

				/**
				 * [tUniqRow_1 finally ] stop
				 */

				/**
				 * [tWarn_1 finally ] start
				 */

				currentComponent = "tWarn_1";

				/**
				 * [tWarn_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_error_log = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_error_log = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String name;

		public String getName() {
			return this.name;
		}

		public Integer age;

		public Integer getAge() {
			return this.age;
		}

		public String species;

		public String getSpecies() {
			return this.species;
		}

		public String color;

		public String getColor() {
			return this.color;
		}

		public Integer contact;

		public Integer getContact() {
			return this.contact;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.contact == null) ? 0 : this.contact.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row2Struct other = (row2Struct) obj;

			if (this.contact == null) {
				if (other.contact != null)
					return false;

			} else if (!this.contact.equals(other.contact))

				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.name = this.name;
			other.age = this.age;
			other.species = this.species;
			other.color = this.color;
			other.contact = this.contact;

		}

		public void copyKeysDataTo(row2Struct other) {

			other.contact = this.contact;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.contact = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.contact = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.contact, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.contact, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.name = readString(dis, ois);

				this.age = readInteger(dis, ois);

				this.species = readString(dis, ois);

				this.color = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.name = readString(dis, objectIn);

				this.age = readInteger(dis, objectIn);

				this.species = readString(dis, objectIn);

				this.color = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.name, dos, oos);

				writeInteger(this.age, dos, oos);

				writeString(this.species, dos, oos);

				writeString(this.color, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.name, dos, objectOut);

				writeInteger(this.age, dos, objectOut);

				writeString(this.species, dos, objectOut);

				writeString(this.color, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("name=" + name);
			sb.append(",age=" + String.valueOf(age));
			sb.append(",species=" + species);
			sb.append(",color=" + color);
			sb.append(",contact=" + String.valueOf(contact));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.contact, other.contact);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFileInputXML_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputXML_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row2Struct row2 = new row2Struct();

				/**
				 * [tAdvancedHash_row2 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row2", false);
				start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tAdvancedHash_row2 = 0;

				// connection name:row2
				// source node:tFileInputXML_1 - inputs:(after_tDBInput_1) outputs:(row2,row2) |
				// target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2)
				// outputs:(ErrorReject,owner_pets,owner_wo_pets)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct>getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
				 */

				/**
				 * [tFileInputXML_1 begin ] start
				 */

				ok_Hash.put("tFileInputXML_1", false);
				start_Hash.put("tFileInputXML_1", System.currentTimeMillis());

				currentComponent = "tFileInputXML_1";

				int tos_count_tFileInputXML_1 = 0;

				int nb_line_tFileInputXML_1 = 0;

				String os_tFileInputXML_1 = System.getProperty("os.name").toLowerCase();
				boolean isWindows_tFileInputXML_1 = false;
				if (os_tFileInputXML_1.indexOf("windows") > -1 || os_tFileInputXML_1.indexOf("nt") > -1) {
					isWindows_tFileInputXML_1 = true;
				}
				class NameSpaceTool_tFileInputXML_1 {

					public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();

					private java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();

					public void countNSMap(org.dom4j.Element el) {
						for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {
							if (ns.getPrefix().trim().length() == 0) {
								xmlNameSpaceMap.put("pre" + defualtNSPath.size(), ns.getURI());
								String path = "";
								org.dom4j.Element elTmp = el;
								while (elTmp != null) {
									if (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {
										path = "/" + elTmp.getNamespacePrefix() + ":" + elTmp.getName() + path;
									} else {
										path = "/" + elTmp.getName() + path;
									}
									elTmp = elTmp.getParent();
								}
								defualtNSPath.add(path);
							} else {
								xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());
							}

						}
						for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {
							countNSMap(e);
						}
					}

					private final org.talend.xpath.XPathUtil util = new org.talend.xpath.XPathUtil();

					{
						util.setDefaultNSPath(defualtNSPath);
					}

					public String addDefaultNSPrefix(String path) {
						return util.addDefaultNSPrefix(path);
					}

					public String addDefaultNSPrefix(String relativeXpression, String basePath) {
						return util.addDefaultNSPrefix(relativeXpression, basePath);
					}

				}

				class XML_API_tFileInputXML_1 {
					public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null && node instanceof org.dom4j.Element) {
							org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
							if (attri != null && ("true").equals(attri.getText())) {
								return true;
							}
						}
						return false;
					}

					public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						return node == null ? true : false;
					}

					public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null) {
							return node.getText().length() == 0;
						}
						return false;
					}
				}

				org.dom4j.io.SAXReader reader_tFileInputXML_1 = new org.dom4j.io.SAXReader();
				Object filename_tFileInputXML_1 = null;
				try {
					filename_tFileInputXML_1 = context.data_dir + "pets_advanced.xml";
				} catch (java.lang.Exception e) {
					globalMap.put("tFileInputXML_1_ERROR_MESSAGE", e.getMessage());

					throw (e);

				}
				if (filename_tFileInputXML_1 != null && filename_tFileInputXML_1 instanceof String
						&& filename_tFileInputXML_1.toString().startsWith("//")) {
					if (!isWindows_tFileInputXML_1) {
						filename_tFileInputXML_1 = filename_tFileInputXML_1.toString().replaceFirst("//", "/");
					}
				}

				boolean isValidFile_tFileInputXML_1 = true;
				org.dom4j.Document doc_tFileInputXML_1 = null;
				java.io.Closeable toClose_tFileInputXML_1 = null;
				try {
					if (filename_tFileInputXML_1 instanceof java.io.InputStream) {
						java.io.InputStream inputStream_tFileInputXML_1 = (java.io.InputStream) filename_tFileInputXML_1;
						toClose_tFileInputXML_1 = inputStream_tFileInputXML_1;
						doc_tFileInputXML_1 = reader_tFileInputXML_1.read(inputStream_tFileInputXML_1);
					} else {
						java.io.Reader unicodeReader_tFileInputXML_1 = new UnicodeReader(
								new java.io.FileInputStream(String.valueOf(filename_tFileInputXML_1)), "UTF-8");
						toClose_tFileInputXML_1 = unicodeReader_tFileInputXML_1;
						org.xml.sax.InputSource in_tFileInputXML_1 = new org.xml.sax.InputSource(
								unicodeReader_tFileInputXML_1);
						doc_tFileInputXML_1 = reader_tFileInputXML_1.read(in_tFileInputXML_1);
					}
				} catch (java.lang.Exception e) {
					globalMap.put("tFileInputXML_1_ERROR_MESSAGE", e.getMessage());
					throw (e);
				} finally {
					if (toClose_tFileInputXML_1 != null) {
						toClose_tFileInputXML_1.close();
					}
				}
				if (isValidFile_tFileInputXML_1) {
					NameSpaceTool_tFileInputXML_1 nsTool_tFileInputXML_1 = new NameSpaceTool_tFileInputXML_1();
					nsTool_tFileInputXML_1.countNSMap(doc_tFileInputXML_1.getRootElement());
					java.util.HashMap<String, String> xmlNameSpaceMap_tFileInputXML_1 = nsTool_tFileInputXML_1.xmlNameSpaceMap;

					org.dom4j.XPath x_tFileInputXML_1 = doc_tFileInputXML_1
							.createXPath(nsTool_tFileInputXML_1.addDefaultNSPrefix("/pets/pet"));
					x_tFileInputXML_1.setNamespaceURIs(xmlNameSpaceMap_tFileInputXML_1);

					java.util.List<org.dom4j.Node> nodeList_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) x_tFileInputXML_1
							.selectNodes(doc_tFileInputXML_1);
					XML_API_tFileInputXML_1 xml_api_tFileInputXML_1 = new XML_API_tFileInputXML_1();
					String str_tFileInputXML_1 = "";
					org.dom4j.Node node_tFileInputXML_1 = null;

//init all mapping xpaths
					java.util.Map<Integer, org.dom4j.XPath> xpaths_tFileInputXML_1 = new java.util.HashMap<Integer, org.dom4j.XPath>();
					class XPathUtil_tFileInputXML_1 {

						public void initXPaths_0(java.util.Map<Integer, org.dom4j.XPath> xpaths,
								NameSpaceTool_tFileInputXML_1 nsTool,
								java.util.HashMap<String, String> xmlNameSpaceMap) {

							org.dom4j.XPath xpath_0 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("name", "/pets/pet"));
							xpath_0.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(0, xpath_0);

							org.dom4j.XPath xpath_1 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("age", "/pets/pet"));
							xpath_1.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(1, xpath_1);

							org.dom4j.XPath xpath_2 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("type/species", "/pets/pet"));
							xpath_2.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(2, xpath_2);

							org.dom4j.XPath xpath_3 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("color", "/pets/pet"));
							xpath_3.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(3, xpath_3);

							org.dom4j.XPath xpath_4 = org.dom4j.DocumentHelper
									.createXPath(nsTool.addDefaultNSPrefix("contact", "/pets/pet"));
							xpath_4.setNamespaceURIs(xmlNameSpaceMap);

							xpaths.put(4, xpath_4);

						}

						public void initXPaths(java.util.Map<Integer, org.dom4j.XPath> xpaths,
								NameSpaceTool_tFileInputXML_1 nsTool,
								java.util.HashMap<String, String> xmlNameSpaceMap) {

							initXPaths_0(xpaths, nsTool, xmlNameSpaceMap);

						}
					}
					XPathUtil_tFileInputXML_1 xPathUtil_tFileInputXML_1 = new XPathUtil_tFileInputXML_1();
					xPathUtil_tFileInputXML_1.initXPaths(xpaths_tFileInputXML_1, nsTool_tFileInputXML_1,
							xmlNameSpaceMap_tFileInputXML_1);
					for (org.dom4j.Node temp_tFileInputXML_1 : nodeList_tFileInputXML_1) {
						if (nb_line_tFileInputXML_1 >= 50) {

							break;
						}
						nb_line_tFileInputXML_1++;

						row2 = null;
						row2 = null;
						boolean whetherReject_tFileInputXML_1 = false;
						row2 = new row2Struct();
						try {
							Object obj0_tFileInputXML_1 = xpaths_tFileInputXML_1.get(0).evaluate(temp_tFileInputXML_1);
							if (obj0_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj0_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj0_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj0_tFileInputXML_1 instanceof String
									|| obj0_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj0_tFileInputXML_1);
							} else if (obj0_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj0_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row2.name = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row2.name = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row2.name = null;
							} else {
								row2.name = str_tFileInputXML_1;
							}
							Object obj1_tFileInputXML_1 = xpaths_tFileInputXML_1.get(1).evaluate(temp_tFileInputXML_1);
							if (obj1_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj1_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj1_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj1_tFileInputXML_1 instanceof String
									|| obj1_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj1_tFileInputXML_1);
							} else if (obj1_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj1_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row2.age = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)
									|| xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row2.age = null;
							} else {
								row2.age = ParserUtils.parseTo_Integer(str_tFileInputXML_1);
							}
							Object obj2_tFileInputXML_1 = xpaths_tFileInputXML_1.get(2).evaluate(temp_tFileInputXML_1);
							if (obj2_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj2_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj2_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj2_tFileInputXML_1 instanceof String
									|| obj2_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj2_tFileInputXML_1);
							} else if (obj2_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj2_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row2.species = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row2.species = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row2.species = null;
							} else {
								row2.species = str_tFileInputXML_1;
							}
							Object obj3_tFileInputXML_1 = xpaths_tFileInputXML_1.get(3).evaluate(temp_tFileInputXML_1);
							if (obj3_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj3_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj3_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj3_tFileInputXML_1 instanceof String
									|| obj3_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj3_tFileInputXML_1);
							} else if (obj3_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj3_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row2.color = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)) {
								row2.color = "";
							} else if (xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row2.color = null;
							} else {
								row2.color = str_tFileInputXML_1;
							}
							Object obj4_tFileInputXML_1 = xpaths_tFileInputXML_1.get(4).evaluate(temp_tFileInputXML_1);
							if (obj4_tFileInputXML_1 == null) {
								node_tFileInputXML_1 = null;
								str_tFileInputXML_1 = "";

							} else if (obj4_tFileInputXML_1 instanceof org.dom4j.Node) {
								node_tFileInputXML_1 = (org.dom4j.Node) obj4_tFileInputXML_1;
								str_tFileInputXML_1 = org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
										org.jaxen.dom4j.DocumentNavigator.getInstance());
							} else if (obj4_tFileInputXML_1 instanceof String
									|| obj4_tFileInputXML_1 instanceof Number) {
								node_tFileInputXML_1 = temp_tFileInputXML_1;
								str_tFileInputXML_1 = String.valueOf(obj4_tFileInputXML_1);
							} else if (obj4_tFileInputXML_1 instanceof java.util.List) {
								java.util.List<org.dom4j.Node> nodes_tFileInputXML_1 = (java.util.List<org.dom4j.Node>) obj4_tFileInputXML_1;
								node_tFileInputXML_1 = nodes_tFileInputXML_1.size() > 0 ? nodes_tFileInputXML_1.get(0)
										: null;
								str_tFileInputXML_1 = node_tFileInputXML_1 == null ? ""
										: org.jaxen.function.StringFunction.evaluate(node_tFileInputXML_1,
												org.jaxen.dom4j.DocumentNavigator.getInstance());
							}
							if (xml_api_tFileInputXML_1.isDefNull(node_tFileInputXML_1)) {
								row2.contact = null;
							} else if (xml_api_tFileInputXML_1.isEmpty(node_tFileInputXML_1)
									|| xml_api_tFileInputXML_1.isMissing(node_tFileInputXML_1)) {
								row2.contact = null;
							} else {
								row2.contact = ParserUtils.parseTo_Integer(str_tFileInputXML_1);
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputXML_1_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputXML_1 = true;
							throw (e);
						}

						/**
						 * [tFileInputXML_1 begin ] stop
						 */

						/**
						 * [tFileInputXML_1 main ] start
						 */

						currentComponent = "tFileInputXML_1";

						tos_count_tFileInputXML_1++;

						/**
						 * [tFileInputXML_1 main ] stop
						 */

						/**
						 * [tFileInputXML_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputXML_1";

						/**
						 * [tFileInputXML_1 process_data_begin ] stop
						 */
// Start of branch "row2"
						if (row2 != null) {

							/**
							 * [tAdvancedHash_row2 main ] start
							 */

							currentComponent = "tAdvancedHash_row2";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row2"

								);
							}

							row2Struct row2_HashRow = new row2Struct();

							row2_HashRow.name = row2.name;

							row2_HashRow.age = row2.age;

							row2_HashRow.species = row2.species;

							row2_HashRow.color = row2.color;

							row2_HashRow.contact = row2.contact;

							tHash_Lookup_row2.put(row2_HashRow);

							tos_count_tAdvancedHash_row2++;

							/**
							 * [tAdvancedHash_row2 main ] stop
							 */

							/**
							 * [tAdvancedHash_row2 process_data_begin ] start
							 */

							currentComponent = "tAdvancedHash_row2";

							/**
							 * [tAdvancedHash_row2 process_data_begin ] stop
							 */

							/**
							 * [tAdvancedHash_row2 process_data_end ] start
							 */

							currentComponent = "tAdvancedHash_row2";

							/**
							 * [tAdvancedHash_row2 process_data_end ] stop
							 */

						} // End of branch "row2"

						/**
						 * [tFileInputXML_1 process_data_end ] start
						 */

						currentComponent = "tFileInputXML_1";

						/**
						 * [tFileInputXML_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputXML_1 end ] start
						 */

						currentComponent = "tFileInputXML_1";

					}
				}
				globalMap.put("tFileInputXML_1_NB_LINE", nb_line_tFileInputXML_1);

				ok_Hash.put("tFileInputXML_1", true);
				end_Hash.put("tFileInputXML_1", System.currentTimeMillis());

				/**
				 * [tFileInputXML_1 end ] stop
				 */

				/**
				 * [tAdvancedHash_row2 end ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				tHash_Lookup_row2.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tAdvancedHash_row2", true);
				end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputXML_1 finally ] start
				 */

				currentComponent = "tFileInputXML_1";

				/**
				 * [tFileInputXML_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row2 finally ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				/**
				 * [tAdvancedHash_row2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputXML_1_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_error_log = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_error_log = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.moment = readDate(dis);

					this.pid = readString(dis);

					this.root_pid = readString(dis);

					this.father_pid = readString(dis);

					this.project = readString(dis);

					this.job = readString(dis);

					this.context = readString(dis);

					this.priority = readInteger(dis);

					this.type = readString(dis);

					this.origin = readString(dis);

					this.message = readString(dis);

					this.code = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.moment = readDate(dis);

					this.pid = readString(dis);

					this.root_pid = readString(dis);

					this.father_pid = readString(dis);

					this.project = readString(dis);

					this.job = readString(dis);

					this.context = readString(dis);

					this.priority = readInteger(dis);

					this.type = readString(dis);

					this.origin = readString(dis);

					this.message = readString(dis);

					this.code = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// java.util.Date

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// java.util.Date

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tLogCatcher_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row3Struct row3 = new row3Struct();

				/**
				 * [tFileOutputDelimited_2 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_2", false);
				start_Hash.put("tFileOutputDelimited_2", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tFileOutputDelimited_2 = 0;

				String fileName_tFileOutputDelimited_2 = "";
				fileName_tFileOutputDelimited_2 = (new java.io.File(context.data_dir + "alert.log")).getAbsolutePath()
						.replace("\\", "/");
				String fullName_tFileOutputDelimited_2 = null;
				String extension_tFileOutputDelimited_2 = null;
				String directory_tFileOutputDelimited_2 = null;
				if ((fileName_tFileOutputDelimited_2.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_2.lastIndexOf(".") < fileName_tFileOutputDelimited_2
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2;
						extension_tFileOutputDelimited_2 = "";
					} else {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0,
								fileName_tFileOutputDelimited_2.lastIndexOf("."));
						extension_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2
								.substring(fileName_tFileOutputDelimited_2.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0,
							fileName_tFileOutputDelimited_2.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_2.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0,
								fileName_tFileOutputDelimited_2.lastIndexOf("."));
						extension_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2
								.substring(fileName_tFileOutputDelimited_2.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2;
						extension_tFileOutputDelimited_2 = "";
					}
					directory_tFileOutputDelimited_2 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_2 = true;
				java.io.File filetFileOutputDelimited_2 = new java.io.File(fileName_tFileOutputDelimited_2);
				globalMap.put("tFileOutputDelimited_2_FILE_NAME", fileName_tFileOutputDelimited_2);
				if (filetFileOutputDelimited_2.exists()) {
					isFileGenerated_tFileOutputDelimited_2 = false;
				}
				int nb_line_tFileOutputDelimited_2 = 0;
				int splitedFileNo_tFileOutputDelimited_2 = 0;
				int currentRow_tFileOutputDelimited_2 = 0;

				final String OUT_DELIM_tFileOutputDelimited_2 = /** Start field tFileOutputDelimited_2:FIELDSEPARATOR */
						";"/** End field tFileOutputDelimited_2:FIELDSEPARATOR */
				;

				final String OUT_DELIM_ROWSEP_tFileOutputDelimited_2 = /**
																		 * Start field
																		 * tFileOutputDelimited_2:ROWSEPARATOR
																		 */
						"\n"/** End field tFileOutputDelimited_2:ROWSEPARATOR */
				;

				// create directory only if not exists
				if (directory_tFileOutputDelimited_2 != null && directory_tFileOutputDelimited_2.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_2 = new java.io.File(directory_tFileOutputDelimited_2);
					if (!dir_tFileOutputDelimited_2.exists()) {
						dir_tFileOutputDelimited_2.mkdirs();
					}
				}

				// routines.system.Row
				java.io.Writer outtFileOutputDelimited_2 = null;

				outtFileOutputDelimited_2 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
						new java.io.FileOutputStream(fileName_tFileOutputDelimited_2, true), "ISO-8859-15"));
				if (filetFileOutputDelimited_2.length() == 0) {
					outtFileOutputDelimited_2.write("moment");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("pid");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("root_pid");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("father_pid");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("project");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("job");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("context");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("priority");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("type");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("origin");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("message");
					outtFileOutputDelimited_2.write(OUT_DELIM_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.write("code");
					outtFileOutputDelimited_2.write(OUT_DELIM_ROWSEP_tFileOutputDelimited_2);
					outtFileOutputDelimited_2.flush();
				}

				resourceMap.put("out_tFileOutputDelimited_2", outtFileOutputDelimited_2);
				resourceMap.put("nb_line_tFileOutputDelimited_2", nb_line_tFileOutputDelimited_2);

				/**
				 * [tFileOutputDelimited_2 begin ] stop
				 */

				/**
				 * [tLogCatcher_1 begin ] start
				 */

				ok_Hash.put("tLogCatcher_1", false);
				start_Hash.put("tLogCatcher_1", System.currentTimeMillis());

				currentComponent = "tLogCatcher_1";

				int tos_count_tLogCatcher_1 = 0;

				try {
					for (LogCatcherUtils.LogCatcherMessage lcm : tLogCatcher_1.getMessages()) {
						row3.type = lcm.getType();
						row3.origin = (lcm.getOrigin() == null || lcm.getOrigin().length() < 1 ? null
								: lcm.getOrigin());
						row3.priority = lcm.getPriority();
						row3.message = lcm.getMessage();
						row3.code = lcm.getCode();

						row3.moment = java.util.Calendar.getInstance().getTime();

						row3.pid = pid;
						row3.root_pid = rootPid;
						row3.father_pid = fatherPid;

						row3.project = projectName;
						row3.job = jobName;
						row3.context = contextStr;

						/**
						 * [tLogCatcher_1 begin ] stop
						 */

						/**
						 * [tLogCatcher_1 main ] start
						 */

						currentComponent = "tLogCatcher_1";

						tos_count_tLogCatcher_1++;

						/**
						 * [tLogCatcher_1 main ] stop
						 */

						/**
						 * [tLogCatcher_1 process_data_begin ] start
						 */

						currentComponent = "tLogCatcher_1";

						/**
						 * [tLogCatcher_1 process_data_begin ] stop
						 */

						/**
						 * [tFileOutputDelimited_2 main ] start
						 */

						currentComponent = "tFileOutputDelimited_2";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row3"

							);
						}

						StringBuilder sb_tFileOutputDelimited_2 = new StringBuilder();
						if (row3.moment != null) {
							sb_tFileOutputDelimited_2
									.append(FormatterUtils.format_Date(row3.moment, "yyyy-MM-dd HH:mm:ss"));
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.pid != null) {
							sb_tFileOutputDelimited_2.append(row3.pid);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.root_pid != null) {
							sb_tFileOutputDelimited_2.append(row3.root_pid);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.father_pid != null) {
							sb_tFileOutputDelimited_2.append(row3.father_pid);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.project != null) {
							sb_tFileOutputDelimited_2.append(row3.project);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.job != null) {
							sb_tFileOutputDelimited_2.append(row3.job);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.context != null) {
							sb_tFileOutputDelimited_2.append(row3.context);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.priority != null) {
							sb_tFileOutputDelimited_2.append(row3.priority);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.type != null) {
							sb_tFileOutputDelimited_2.append(row3.type);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.origin != null) {
							sb_tFileOutputDelimited_2.append(row3.origin);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.message != null) {
							sb_tFileOutputDelimited_2.append(row3.message);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_tFileOutputDelimited_2);
						if (row3.code != null) {
							sb_tFileOutputDelimited_2.append(row3.code);
						}
						sb_tFileOutputDelimited_2.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_2);

						nb_line_tFileOutputDelimited_2++;
						resourceMap.put("nb_line_tFileOutputDelimited_2", nb_line_tFileOutputDelimited_2);

						outtFileOutputDelimited_2.write(sb_tFileOutputDelimited_2.toString());

						tos_count_tFileOutputDelimited_2++;

						/**
						 * [tFileOutputDelimited_2 main ] stop
						 */

						/**
						 * [tFileOutputDelimited_2 process_data_begin ] start
						 */

						currentComponent = "tFileOutputDelimited_2";

						/**
						 * [tFileOutputDelimited_2 process_data_begin ] stop
						 */

						/**
						 * [tFileOutputDelimited_2 process_data_end ] start
						 */

						currentComponent = "tFileOutputDelimited_2";

						/**
						 * [tFileOutputDelimited_2 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_1 process_data_end ] start
						 */

						currentComponent = "tLogCatcher_1";

						/**
						 * [tLogCatcher_1 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_1 end ] start
						 */

						currentComponent = "tLogCatcher_1";

					}
				} catch (Exception e_tLogCatcher_1) {
					globalMap.put("tLogCatcher_1_ERROR_MESSAGE", e_tLogCatcher_1.getMessage());
					logIgnoredError(String.format(
							"tLogCatcher_1 - tLogCatcher failed to process log message(s) due to internal error: %s",
							e_tLogCatcher_1), e_tLogCatcher_1);
				}

				ok_Hash.put("tLogCatcher_1", true);
				end_Hash.put("tLogCatcher_1", System.currentTimeMillis());

				/**
				 * [tLogCatcher_1 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_2 end ] start
				 */

				currentComponent = "tFileOutputDelimited_2";

				if (outtFileOutputDelimited_2 != null) {
					outtFileOutputDelimited_2.flush();
					outtFileOutputDelimited_2.close();
				}

				globalMap.put("tFileOutputDelimited_2_NB_LINE", nb_line_tFileOutputDelimited_2);
				globalMap.put("tFileOutputDelimited_2_FILE_NAME", fileName_tFileOutputDelimited_2);

				resourceMap.put("finish_tFileOutputDelimited_2", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tFileOutputDelimited_2", true);
				end_Hash.put("tFileOutputDelimited_2", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tSetGlobalVar_2Process(globalMap);

				/**
				 * [tFileOutputDelimited_2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tLogCatcher_1 finally ] start
				 */

				currentComponent = "tLogCatcher_1";

				/**
				 * [tLogCatcher_1 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_2 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_2";

				if (resourceMap.get("finish_tFileOutputDelimited_2") == null) {

					java.io.Writer outtFileOutputDelimited_2 = (java.io.Writer) resourceMap
							.get("out_tFileOutputDelimited_2");
					if (outtFileOutputDelimited_2 != null) {
						outtFileOutputDelimited_2.flush();
						outtFileOutputDelimited_2.close();
					}

				}

				/**
				 * [tFileOutputDelimited_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 1);
	}

	public void tSetGlobalVar_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tSetGlobalVar_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tSetGlobalVar_2 begin ] start
				 */

				ok_Hash.put("tSetGlobalVar_2", false);
				start_Hash.put("tSetGlobalVar_2", System.currentTimeMillis());

				currentComponent = "tSetGlobalVar_2";

				int tos_count_tSetGlobalVar_2 = 0;

				/**
				 * [tSetGlobalVar_2 begin ] stop
				 */

				/**
				 * [tSetGlobalVar_2 main ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				globalMap.put("has_alert", true);

				tos_count_tSetGlobalVar_2++;

				/**
				 * [tSetGlobalVar_2 main ] stop
				 */

				/**
				 * [tSetGlobalVar_2 process_data_begin ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				/**
				 * [tSetGlobalVar_2 process_data_begin ] stop
				 */

				/**
				 * [tSetGlobalVar_2 process_data_end ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				/**
				 * [tSetGlobalVar_2 process_data_end ] stop
				 */

				/**
				 * [tSetGlobalVar_2 end ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				ok_Hash.put("tSetGlobalVar_2", true);
				end_Hash.put("tSetGlobalVar_2", System.currentTimeMillis());

				/**
				 * [tSetGlobalVar_2 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tSetGlobalVar_2 finally ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				/**
				 * [tSetGlobalVar_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tSetGlobalVar_2_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_FORMATION_S25_error_log = new byte[0];
		static byte[] commonByteArray_FORMATION_S25_error_log = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_FORMATION_S25_error_log.length) {
					if (length < 1024 && commonByteArray_FORMATION_S25_error_log.length == 0) {
						commonByteArray_FORMATION_S25_error_log = new byte[1024];
					} else {
						commonByteArray_FORMATION_S25_error_log = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_FORMATION_S25_error_log, 0, length);
				strReturn = new String(commonByteArray_FORMATION_S25_error_log, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.moment = readDate(dis);

					this.pid = readString(dis);

					this.root_pid = readString(dis);

					this.father_pid = readString(dis);

					this.project = readString(dis);

					this.job = readString(dis);

					this.context = readString(dis);

					this.priority = readInteger(dis);

					this.type = readString(dis);

					this.origin = readString(dis);

					this.message = readString(dis);

					this.code = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_FORMATION_S25_error_log) {

				try {

					int length = 0;

					this.moment = readDate(dis);

					this.pid = readString(dis);

					this.root_pid = readString(dis);

					this.father_pid = readString(dis);

					this.project = readString(dis);

					this.job = readString(dis);

					this.context = readString(dis);

					this.priority = readInteger(dis);

					this.type = readString(dis);

					this.origin = readString(dis);

					this.message = readString(dis);

					this.code = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// java.util.Date

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// java.util.Date

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tLogCatcher_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tLogCatcher_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row4Struct row4 = new row4Struct();

				/**
				 * [tFileOutputDelimited_3 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_3", false);
				start_Hash.put("tFileOutputDelimited_3", System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tFileOutputDelimited_3 = 0;

				String fileName_tFileOutputDelimited_3 = "";
				fileName_tFileOutputDelimited_3 = (new java.io.File(context.data_dir + "error.log")).getAbsolutePath()
						.replace("\\", "/");
				String fullName_tFileOutputDelimited_3 = null;
				String extension_tFileOutputDelimited_3 = null;
				String directory_tFileOutputDelimited_3 = null;
				if ((fileName_tFileOutputDelimited_3.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_3.lastIndexOf(".") < fileName_tFileOutputDelimited_3
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3;
						extension_tFileOutputDelimited_3 = "";
					} else {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3.substring(0,
								fileName_tFileOutputDelimited_3.lastIndexOf("."));
						extension_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3
								.substring(fileName_tFileOutputDelimited_3.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3.substring(0,
							fileName_tFileOutputDelimited_3.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_3.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3.substring(0,
								fileName_tFileOutputDelimited_3.lastIndexOf("."));
						extension_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3
								.substring(fileName_tFileOutputDelimited_3.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_3 = fileName_tFileOutputDelimited_3;
						extension_tFileOutputDelimited_3 = "";
					}
					directory_tFileOutputDelimited_3 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_3 = true;
				java.io.File filetFileOutputDelimited_3 = new java.io.File(fileName_tFileOutputDelimited_3);
				globalMap.put("tFileOutputDelimited_3_FILE_NAME", fileName_tFileOutputDelimited_3);
				if (filetFileOutputDelimited_3.exists()) {
					isFileGenerated_tFileOutputDelimited_3 = false;
				}
				int nb_line_tFileOutputDelimited_3 = 0;
				int splitedFileNo_tFileOutputDelimited_3 = 0;
				int currentRow_tFileOutputDelimited_3 = 0;

				final String OUT_DELIM_tFileOutputDelimited_3 = /** Start field tFileOutputDelimited_3:FIELDSEPARATOR */
						";"/** End field tFileOutputDelimited_3:FIELDSEPARATOR */
				;

				final String OUT_DELIM_ROWSEP_tFileOutputDelimited_3 = /**
																		 * Start field
																		 * tFileOutputDelimited_3:ROWSEPARATOR
																		 */
						"\n"/** End field tFileOutputDelimited_3:ROWSEPARATOR */
				;

				// create directory only if not exists
				if (directory_tFileOutputDelimited_3 != null && directory_tFileOutputDelimited_3.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_3 = new java.io.File(directory_tFileOutputDelimited_3);
					if (!dir_tFileOutputDelimited_3.exists()) {
						dir_tFileOutputDelimited_3.mkdirs();
					}
				}

				// routines.system.Row
				java.io.Writer outtFileOutputDelimited_3 = null;

				outtFileOutputDelimited_3 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
						new java.io.FileOutputStream(fileName_tFileOutputDelimited_3, true), "ISO-8859-15"));

				resourceMap.put("out_tFileOutputDelimited_3", outtFileOutputDelimited_3);
				resourceMap.put("nb_line_tFileOutputDelimited_3", nb_line_tFileOutputDelimited_3);

				/**
				 * [tFileOutputDelimited_3 begin ] stop
				 */

				/**
				 * [tLogCatcher_2 begin ] start
				 */

				ok_Hash.put("tLogCatcher_2", false);
				start_Hash.put("tLogCatcher_2", System.currentTimeMillis());

				currentComponent = "tLogCatcher_2";

				int tos_count_tLogCatcher_2 = 0;

				try {
					for (LogCatcherUtils.LogCatcherMessage lcm : tLogCatcher_2.getMessages()) {
						row4.type = lcm.getType();
						row4.origin = (lcm.getOrigin() == null || lcm.getOrigin().length() < 1 ? null
								: lcm.getOrigin());
						row4.priority = lcm.getPriority();
						row4.message = lcm.getMessage();
						row4.code = lcm.getCode();

						row4.moment = java.util.Calendar.getInstance().getTime();

						row4.pid = pid;
						row4.root_pid = rootPid;
						row4.father_pid = fatherPid;

						row4.project = projectName;
						row4.job = jobName;
						row4.context = contextStr;

						/**
						 * [tLogCatcher_2 begin ] stop
						 */

						/**
						 * [tLogCatcher_2 main ] start
						 */

						currentComponent = "tLogCatcher_2";

						tos_count_tLogCatcher_2++;

						/**
						 * [tLogCatcher_2 main ] stop
						 */

						/**
						 * [tLogCatcher_2 process_data_begin ] start
						 */

						currentComponent = "tLogCatcher_2";

						/**
						 * [tLogCatcher_2 process_data_begin ] stop
						 */

						/**
						 * [tFileOutputDelimited_3 main ] start
						 */

						currentComponent = "tFileOutputDelimited_3";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row4"

							);
						}

						StringBuilder sb_tFileOutputDelimited_3 = new StringBuilder();
						if (row4.moment != null) {
							sb_tFileOutputDelimited_3
									.append(FormatterUtils.format_Date(row4.moment, "yyyy-MM-dd HH:mm:ss"));
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.pid != null) {
							sb_tFileOutputDelimited_3.append(row4.pid);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.root_pid != null) {
							sb_tFileOutputDelimited_3.append(row4.root_pid);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.father_pid != null) {
							sb_tFileOutputDelimited_3.append(row4.father_pid);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.project != null) {
							sb_tFileOutputDelimited_3.append(row4.project);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.job != null) {
							sb_tFileOutputDelimited_3.append(row4.job);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.context != null) {
							sb_tFileOutputDelimited_3.append(row4.context);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.priority != null) {
							sb_tFileOutputDelimited_3.append(row4.priority);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.type != null) {
							sb_tFileOutputDelimited_3.append(row4.type);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.origin != null) {
							sb_tFileOutputDelimited_3.append(row4.origin);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.message != null) {
							sb_tFileOutputDelimited_3.append(row4.message);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_tFileOutputDelimited_3);
						if (row4.code != null) {
							sb_tFileOutputDelimited_3.append(row4.code);
						}
						sb_tFileOutputDelimited_3.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_3);

						nb_line_tFileOutputDelimited_3++;
						resourceMap.put("nb_line_tFileOutputDelimited_3", nb_line_tFileOutputDelimited_3);

						outtFileOutputDelimited_3.write(sb_tFileOutputDelimited_3.toString());

						tos_count_tFileOutputDelimited_3++;

						/**
						 * [tFileOutputDelimited_3 main ] stop
						 */

						/**
						 * [tFileOutputDelimited_3 process_data_begin ] start
						 */

						currentComponent = "tFileOutputDelimited_3";

						/**
						 * [tFileOutputDelimited_3 process_data_begin ] stop
						 */

						/**
						 * [tFileOutputDelimited_3 process_data_end ] start
						 */

						currentComponent = "tFileOutputDelimited_3";

						/**
						 * [tFileOutputDelimited_3 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_2 process_data_end ] start
						 */

						currentComponent = "tLogCatcher_2";

						/**
						 * [tLogCatcher_2 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_2 end ] start
						 */

						currentComponent = "tLogCatcher_2";

					}
				} catch (Exception e_tLogCatcher_2) {
					globalMap.put("tLogCatcher_2_ERROR_MESSAGE", e_tLogCatcher_2.getMessage());
					logIgnoredError(String.format(
							"tLogCatcher_2 - tLogCatcher failed to process log message(s) due to internal error: %s",
							e_tLogCatcher_2), e_tLogCatcher_2);
				}

				ok_Hash.put("tLogCatcher_2", true);
				end_Hash.put("tLogCatcher_2", System.currentTimeMillis());

				/**
				 * [tLogCatcher_2 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_3 end ] start
				 */

				currentComponent = "tFileOutputDelimited_3";

				if (outtFileOutputDelimited_3 != null) {
					outtFileOutputDelimited_3.flush();
					outtFileOutputDelimited_3.close();
				}

				globalMap.put("tFileOutputDelimited_3_NB_LINE", nb_line_tFileOutputDelimited_3);
				globalMap.put("tFileOutputDelimited_3_FILE_NAME", fileName_tFileOutputDelimited_3);

				resourceMap.put("finish_tFileOutputDelimited_3", true);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tFileOutputDelimited_3", true);
				end_Hash.put("tFileOutputDelimited_3", System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_3 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tLogCatcher_2 finally ] start
				 */

				currentComponent = "tLogCatcher_2";

				/**
				 * [tLogCatcher_2 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_3 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_3";

				if (resourceMap.get("finish_tFileOutputDelimited_3") == null) {

					java.io.Writer outtFileOutputDelimited_3 = (java.io.Writer) resourceMap
							.get("out_tFileOutputDelimited_3");
					if (outtFileOutputDelimited_3 != null) {
						outtFileOutputDelimited_3.flush();
						outtFileOutputDelimited_3.close();
					}

				}

				/**
				 * [tFileOutputDelimited_3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tLogCatcher_2_SUBPROCESS_STATE", 1);
	}

	public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPostjob_1 begin ] start
				 */

				ok_Hash.put("tPostjob_1", false);
				start_Hash.put("tPostjob_1", System.currentTimeMillis());

				currentComponent = "tPostjob_1";

				int tos_count_tPostjob_1 = 0;

				/**
				 * [tPostjob_1 begin ] stop
				 */

				/**
				 * [tPostjob_1 main ] start
				 */

				currentComponent = "tPostjob_1";

				tos_count_tPostjob_1++;

				/**
				 * [tPostjob_1 main ] stop
				 */

				/**
				 * [tPostjob_1 process_data_begin ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_begin ] stop
				 */

				/**
				 * [tPostjob_1 process_data_end ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 process_data_end ] stop
				 */

				/**
				 * [tPostjob_1 end ] start
				 */

				currentComponent = "tPostjob_1";

				ok_Hash.put("tPostjob_1", true);
				end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tJava_1Process(globalMap);

				/**
				 * [tPostjob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tPostjob_1 finally ] start
				 */

				currentComponent = "tPostjob_1";

				/**
				 * [tPostjob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}

	public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tJava_1 begin ] start
				 */

				ok_Hash.put("tJava_1", false);
				start_Hash.put("tJava_1", System.currentTimeMillis());

				currentComponent = "tJava_1";

				int tos_count_tJava_1 = 0;

				System.out.println(((boolean) globalMap.get("has_alert")));

				/**
				 * [tJava_1 begin ] stop
				 */

				/**
				 * [tJava_1 main ] start
				 */

				currentComponent = "tJava_1";

				tos_count_tJava_1++;

				/**
				 * [tJava_1 main ] stop
				 */

				/**
				 * [tJava_1 process_data_begin ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 process_data_begin ] stop
				 */

				/**
				 * [tJava_1 process_data_end ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 process_data_end ] stop
				 */

				/**
				 * [tJava_1 end ] start
				 */

				currentComponent = "tJava_1";

				ok_Hash.put("tJava_1", true);
				end_Hash.put("tJava_1", System.currentTimeMillis());

				if (((boolean) globalMap.get("has_alert"))) {

					if (execStat) {
						runStat.updateStatOnConnection("If1", 0, "true");
					}
					tSendMail_1Process(globalMap);
				}

				else {
					if (execStat) {
						runStat.updateStatOnConnection("If1", 0, "false");
					}
				}

				/**
				 * [tJava_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tJava_1 finally ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}

	public void tSendMail_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tSendMail_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tSendMail_1 begin ] start
				 */

				ok_Hash.put("tSendMail_1", false);
				start_Hash.put("tSendMail_1", System.currentTimeMillis());

				currentComponent = "tSendMail_1";

				int tos_count_tSendMail_1 = 0;

				/**
				 * [tSendMail_1 begin ] stop
				 */

				/**
				 * [tSendMail_1 main ] start
				 */

				currentComponent = "tSendMail_1";

				String smtpHost_tSendMail_1 = "192.168.1.19";
				String smtpPort_tSendMail_1 = "1025";
				String from_tSendMail_1 = ("send@example.com");
				String to_tSendMail_1 = ("receiver@example.com").replace(";", ",");
				String cc_tSendMail_1 = (("carbon@example.com") == null || "".equals("carbon@example.com")) ? null
						: ("carbon@example.com").replace(";", ",");
				String bcc_tSendMail_1 = (("blindcarbon@example.com") == null || "".equals("blindcarbon@example.com"))
						? null
						: ("blindcarbon@example.com").replace(";", ",");
				String subject_tSendMail_1 = ("ALERT ON " + projectName + "-" + jobName);

				java.util.List<java.util.Map<String, String>> headers_tSendMail_1 = new java.util.ArrayList<java.util.Map<String, String>>();
				java.util.List<String> attachments_tSendMail_1 = new java.util.ArrayList<String>();
				java.util.List<String> contentTransferEncoding_tSendMail_1 = new java.util.ArrayList<String>();
				attachments_tSendMail_1.add(context.data_dir + "alert.log");
				contentTransferEncoding_tSendMail_1.add("BASE64");

				String message_tSendMail_1 = (("Hello, admin, some errors on " + projectName + ":" + jobName + ".\n"
						+ "See file below") == null
						|| "".equals("Hello, admin, some errors on " + projectName + ":" + jobName + ".\n"
								+ "See file below")) ? "\"\""
										: ("Hello, admin, some errors on " + projectName + ":" + jobName + ".\n"
												+ "See file below");
				java.util.Properties props_tSendMail_1 = System.getProperties();
				props_tSendMail_1.put("mail.smtp.host", smtpHost_tSendMail_1);
				props_tSendMail_1.put("mail.smtp.port", smtpPort_tSendMail_1);
				props_tSendMail_1.put("mail.mime.encodefilename", "true");
				try {

					props_tSendMail_1.put("mail.smtp.auth", "false");
					javax.mail.Session session_tSendMail_1 = javax.mail.Session.getInstance(props_tSendMail_1, null);

					javax.mail.Message msg_tSendMail_1 = new javax.mail.internet.MimeMessage(session_tSendMail_1);
					msg_tSendMail_1.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_1, null));
					msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.TO,
							javax.mail.internet.InternetAddress.parse(to_tSendMail_1, false));
					if (cc_tSendMail_1 != null)
						msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.CC,
								javax.mail.internet.InternetAddress.parse(cc_tSendMail_1, false));
					if (bcc_tSendMail_1 != null)
						msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.BCC,
								javax.mail.internet.InternetAddress.parse(bcc_tSendMail_1, false));
					msg_tSendMail_1.setSubject(subject_tSendMail_1);

					for (int i_tSendMail_1 = 0; i_tSendMail_1 < headers_tSendMail_1.size(); i_tSendMail_1++) {
						java.util.Map<String, String> header_tSendMail_1 = headers_tSendMail_1.get(i_tSendMail_1);
						msg_tSendMail_1.setHeader(header_tSendMail_1.get("KEY"), header_tSendMail_1.get("VALUE"));
					}
					msg_tSendMail_1.setSentDate(new Date());
					msg_tSendMail_1.setHeader("X-Priority", "3"); // High->1 Normal->3 Low->5
					javax.mail.Multipart mp_tSendMail_1 = new javax.mail.internet.MimeMultipart();
					javax.mail.internet.MimeBodyPart mbpText_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
					mbpText_tSendMail_1.setText(message_tSendMail_1, "ISO-8859-15", "plain");
					mp_tSendMail_1.addBodyPart(mbpText_tSendMail_1);

					javax.mail.internet.MimeBodyPart mbpFile_tSendMail_1 = null;

					for (int i_tSendMail_1 = 0; i_tSendMail_1 < attachments_tSendMail_1.size(); i_tSendMail_1++) {
						String filename_tSendMail_1 = attachments_tSendMail_1.get(i_tSendMail_1);
						javax.activation.FileDataSource fds_tSendMail_1 = null;
						java.io.File file_tSendMail_1 = new java.io.File(filename_tSendMail_1);

						if (file_tSendMail_1.isDirectory()) {
							java.io.File[] subFiles_tSendMail_1 = file_tSendMail_1.listFiles();
							for (java.io.File subFile_tSendMail_1 : subFiles_tSendMail_1) {
								if (subFile_tSendMail_1.isFile()) {
									fds_tSendMail_1 = new javax.activation.FileDataSource(
											subFile_tSendMail_1.getAbsolutePath());
									mbpFile_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
									mbpFile_tSendMail_1
											.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_1));
									mbpFile_tSendMail_1.setFileName(
											javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_1.getName()));
									if (contentTransferEncoding_tSendMail_1.get(i_tSendMail_1)
											.equalsIgnoreCase("base64")) {
										mbpFile_tSendMail_1.setHeader("Content-Transfer-Encoding", "base64");
									}
									mp_tSendMail_1.addBodyPart(mbpFile_tSendMail_1);
								}
							}
						} else {
							mbpFile_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
							fds_tSendMail_1 = new javax.activation.FileDataSource(filename_tSendMail_1);
							mbpFile_tSendMail_1.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_1));
							mbpFile_tSendMail_1
									.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_1.getName()));
							if (contentTransferEncoding_tSendMail_1.get(i_tSendMail_1).equalsIgnoreCase("base64")) {
								mbpFile_tSendMail_1.setHeader("Content-Transfer-Encoding", "base64");
							}
							mp_tSendMail_1.addBodyPart(mbpFile_tSendMail_1);
						}
					}
					// -- set the content --
					msg_tSendMail_1.setContent(mp_tSendMail_1);
					// add handlers for main MIME types
					javax.activation.MailcapCommandMap mc_tSendMail_1 = (javax.activation.MailcapCommandMap) javax.activation.CommandMap
							.getDefaultCommandMap();
					mc_tSendMail_1.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
					mc_tSendMail_1.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
					mc_tSendMail_1.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
					mc_tSendMail_1
							.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
					mc_tSendMail_1
							.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
					javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_1);
					// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
					com.sun.mail.handlers.text_plain text_plain_h_tSendMail_1 = null;
					// -- Send the message --
					javax.mail.Transport.send(msg_tSendMail_1);
				} catch (java.lang.Exception e) {
					globalMap.put("tSendMail_1_ERROR_MESSAGE", e.getMessage());

					throw (e);

				} finally {
					props_tSendMail_1.remove("mail.smtp.host");
					props_tSendMail_1.remove("mail.smtp.port");

					props_tSendMail_1.remove("mail.mime.encodefilename");

					props_tSendMail_1.remove("mail.smtp.auth");
				}

				tos_count_tSendMail_1++;

				/**
				 * [tSendMail_1 main ] stop
				 */

				/**
				 * [tSendMail_1 process_data_begin ] start
				 */

				currentComponent = "tSendMail_1";

				/**
				 * [tSendMail_1 process_data_begin ] stop
				 */

				/**
				 * [tSendMail_1 process_data_end ] start
				 */

				currentComponent = "tSendMail_1";

				/**
				 * [tSendMail_1 process_data_end ] stop
				 */

				/**
				 * [tSendMail_1 end ] start
				 */

				currentComponent = "tSendMail_1";

				ok_Hash.put("tSendMail_1", true);
				end_Hash.put("tSendMail_1", System.currentTimeMillis());

				/**
				 * [tSendMail_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tSendMail_1 finally ] start
				 */

				currentComponent = "tSendMail_1";

				/**
				 * [tSendMail_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tSendMail_1_SUBPROCESS_STATE", 1);
	}

	public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPrejob_1 begin ] start
				 */

				ok_Hash.put("tPrejob_1", false);
				start_Hash.put("tPrejob_1", System.currentTimeMillis());

				currentComponent = "tPrejob_1";

				int tos_count_tPrejob_1 = 0;

				/**
				 * [tPrejob_1 begin ] stop
				 */

				/**
				 * [tPrejob_1 main ] start
				 */

				currentComponent = "tPrejob_1";

				tos_count_tPrejob_1++;

				/**
				 * [tPrejob_1 main ] stop
				 */

				/**
				 * [tPrejob_1 process_data_begin ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_begin ] stop
				 */

				/**
				 * [tPrejob_1 process_data_end ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_end ] stop
				 */

				/**
				 * [tPrejob_1 end ] start
				 */

				currentComponent = "tPrejob_1";

				ok_Hash.put("tPrejob_1", true);
				end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tSetGlobalVar_1Process(globalMap);

				/**
				 * [tPrejob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tPrejob_1 finally ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}

	public void tSetGlobalVar_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tSetGlobalVar_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tSetGlobalVar_1 begin ] start
				 */

				ok_Hash.put("tSetGlobalVar_1", false);
				start_Hash.put("tSetGlobalVar_1", System.currentTimeMillis());

				currentComponent = "tSetGlobalVar_1";

				int tos_count_tSetGlobalVar_1 = 0;

				/**
				 * [tSetGlobalVar_1 begin ] stop
				 */

				/**
				 * [tSetGlobalVar_1 main ] start
				 */

				currentComponent = "tSetGlobalVar_1";

				globalMap.put("has_alert", false);

				tos_count_tSetGlobalVar_1++;

				/**
				 * [tSetGlobalVar_1 main ] stop
				 */

				/**
				 * [tSetGlobalVar_1 process_data_begin ] start
				 */

				currentComponent = "tSetGlobalVar_1";

				/**
				 * [tSetGlobalVar_1 process_data_begin ] stop
				 */

				/**
				 * [tSetGlobalVar_1 process_data_end ] start
				 */

				currentComponent = "tSetGlobalVar_1";

				/**
				 * [tSetGlobalVar_1 process_data_end ] stop
				 */

				/**
				 * [tSetGlobalVar_1 end ] start
				 */

				currentComponent = "tSetGlobalVar_1";

				ok_Hash.put("tSetGlobalVar_1", true);
				end_Hash.put("tSetGlobalVar_1", System.currentTimeMillis());

				/**
				 * [tSetGlobalVar_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tSetGlobalVar_1 finally ] start
				 */

				currentComponent = "tSetGlobalVar_1";

				/**
				 * [tSetGlobalVar_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tSetGlobalVar_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final error_log error_logClass = new error_log();

		int exitCode = error_logClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = error_log.class.getClassLoader()
					.getResourceAsStream("formation_s25/error_log_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = error_log.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("db_in_AdditionalParams", "id_String");
					if (context.getStringValue("db_in_AdditionalParams") == null) {
						context.db_in_AdditionalParams = null;
					} else {
						context.db_in_AdditionalParams = (String) context.getProperty("db_in_AdditionalParams");
					}
					context.setContextType("db_in_Password", "id_Password");
					if (context.getStringValue("db_in_Password") == null) {
						context.db_in_Password = null;
					} else {
						String pwd_db_in_Password_value = context.getProperty("db_in_Password");
						context.db_in_Password = null;
						if (pwd_db_in_Password_value != null) {
							if (context_param.containsKey("db_in_Password")) {// no need to decrypt if it come from
																				// program argument or parent job
																				// runtime
								context.db_in_Password = pwd_db_in_Password_value;
							} else if (!pwd_db_in_Password_value.isEmpty()) {
								try {
									context.db_in_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_db_in_Password_value);
									context.put("db_in_Password", context.db_in_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("db_in_Server", "id_String");
					if (context.getStringValue("db_in_Server") == null) {
						context.db_in_Server = null;
					} else {
						context.db_in_Server = (String) context.getProperty("db_in_Server");
					}
					context.setContextType("db_in_Port", "id_String");
					if (context.getStringValue("db_in_Port") == null) {
						context.db_in_Port = null;
					} else {
						context.db_in_Port = (String) context.getProperty("db_in_Port");
					}
					context.setContextType("db_in_Login", "id_String");
					if (context.getStringValue("db_in_Login") == null) {
						context.db_in_Login = null;
					} else {
						context.db_in_Login = (String) context.getProperty("db_in_Login");
					}
					context.setContextType("db_in_Database", "id_String");
					if (context.getStringValue("db_in_Database") == null) {
						context.db_in_Database = null;
					} else {
						context.db_in_Database = (String) context.getProperty("db_in_Database");
					}
					context.setContextType("api_url", "id_String");
					if (context.getStringValue("api_url") == null) {
						context.api_url = null;
					} else {
						context.api_url = (String) context.getProperty("api_url");
					}
					context.setContextType("nb_cpus", "id_Integer");
					if (context.getStringValue("nb_cpus") == null) {
						context.nb_cpus = null;
					} else {
						try {
							context.nb_cpus = routines.system.ParserUtils
									.parseTo_Integer(context.getProperty("nb_cpus"));
						} catch (NumberFormatException e) {
							System.err.println(String.format("Null value will be used for context parameter %s: %s",
									"nb_cpus", e.getMessage()));
							context.nb_cpus = null;
						}
					}
					context.setContextType("data_dir", "id_String");
					if (context.getStringValue("data_dir") == null) {
						context.data_dir = null;
					} else {
						context.data_dir = (String) context.getProperty("data_dir");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("db_in_AdditionalParams")) {
				context.db_in_AdditionalParams = (String) parentContextMap.get("db_in_AdditionalParams");
			}
			if (parentContextMap.containsKey("db_in_Password")) {
				context.db_in_Password = (java.lang.String) parentContextMap.get("db_in_Password");
			}
			if (parentContextMap.containsKey("db_in_Server")) {
				context.db_in_Server = (String) parentContextMap.get("db_in_Server");
			}
			if (parentContextMap.containsKey("db_in_Port")) {
				context.db_in_Port = (String) parentContextMap.get("db_in_Port");
			}
			if (parentContextMap.containsKey("db_in_Login")) {
				context.db_in_Login = (String) parentContextMap.get("db_in_Login");
			}
			if (parentContextMap.containsKey("db_in_Database")) {
				context.db_in_Database = (String) parentContextMap.get("db_in_Database");
			}
			if (parentContextMap.containsKey("api_url")) {
				context.api_url = (String) parentContextMap.get("api_url");
			}
			if (parentContextMap.containsKey("nb_cpus")) {
				context.nb_cpus = (Integer) parentContextMap.get("nb_cpus");
			}
			if (parentContextMap.containsKey("data_dir")) {
				context.data_dir = (String) parentContextMap.get("data_dir");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("db_in_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		try {
			errorCode = null;
			tPrejob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPrejob_1) {
			globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

			e_tPrejob_1.printStackTrace();

		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_1) {
			globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

			e_tDBInput_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		try {
			errorCode = null;
			tPostjob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPostjob_1) {
			globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

			e_tPostjob_1.printStackTrace();

		}

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : error_log");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 225860 characters generated by Talend Open Studio for Data Integration on the
 * 24 juin 2022 à 12:25:51 CEST
 ************************************************************************************************/