package learnRegex;

import kl.field.Field;
import kl.field.type.BoolType;
import kl.field.type.IPType;
import kl.field.type.IntType;
import kl.field.type.StringType;

/**
 *
 * @author louhf
 */
public class TbVlan {

    public static final String TABLE = "WOF_TB_VLAN";

	public static final Field IFACE = new Field("�ӿ�", "iface", new StringType(), true, true);
    public static final Field VLANID = new Field("ID", "id", new IntType(0, 65535), true);
	public static final Field ADDRESS = new Field("IP��ַ", "address", new IPType(), true);
	public static final Field NETMASK = new Field("��������", "netmask", new IntType(0, 32), true);
    public static final Field NETWORK = new Field("����", "network", new IPType());
	public static final Field BROADCAST = new Field("�㲥", "broadcast", new IPType());
	public static final Field MTU = new Field("����䵥Ԫ", "mtu", new IntType(46, 1500), true);
	public static final Field AUTO = new Field("�Զ�����", "auto", new BoolType());
	public static final Field NET_NAME_EXT = new Field("NET_NAME_EXT", "net_name_ext",  new StringType());

    //====================================
    // ������ű�
    public static final String CREATE = String.format(
            "create table if not exists %s ("
                    + "%s TEXT PRIMARY KEY NOT NULL,"
                    + "%s INTEGER,"

                    + "%s TEXT,"
					+ "%s TEXT,"
                    + "%s INTEGER,"

                    + "%s TEXT,"
                    + "%s TEXT,"
                    + "%s TEXT,"


                    + "%s INTEGER)",

            TABLE,
            IFACE.name,
            VLANID.name,


            NET_NAME_EXT.name,
            ADDRESS.name,
            NETMASK.name,

            NETWORK.name,
            BROADCAST.name,
            AUTO.name,

            MTU.name
    );

    //ɾ����ű�
    public static final String DROP = String.format(
            "drop table if exists %s", TABLE);

}
