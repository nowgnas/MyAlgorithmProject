/*
package 암호화;

import java.util.UUID;
import javax.annotation.Resource;


public class MemberService {

    @Service
    public class MemberService {
        @Resource(name = "memberDao")
        private MemberDao dao;

        public void deleteMember(MemberModel memberModel) {
            dao.deleteMember(memberModel);
        }

        public boolean modifyMember(MemberModel memberModel) {
            try {
                SecVO sec = dao.selectSecurity(memberModel.getUserId());
                memberModel.setUserPw(
                        new
                                String(OpenCrypt.getSHA256(memberModel.getUserPw(), sec.getSalt())));
                dao.updateMember(memberModel);
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        public int addMember(MemberModel memberModel) {
            if (dao.selectMember(memberModel.getUserId()) != null) {
                return 1;
            } else {
                try {
                    byte[] key = OpenCrypt.generateKey("AES", 128);
                    System.out.println("key length:" + key.length);
                    SecVO sec =
                            new
                                    SecVO(memberModel.getUserId(), UUID.randomUUID().toString(), OpenCrypt.byteArrayToHex(k
                                    ey));
                    dao.insertSecurity(sec);
                    memberModel.setUserName(OpenCrypt.aesEncrypt(memberModel.getUserName(), key));
                    memberModel.setUserPw(new
                            String(OpenCrypt.getSHA256(memberModel.getUserPw(), sec.getSalt())));
                    dao.insertMember(memberModel);
                    return 3;
                } catch (Exception e) {
                    e.printStackTrace();
                    return 2;
                }
            }
        }

        public MemberModel findMember(String userId) {
            MemberModel m = dao.selectMember(userId);
            SecVO sec = dao.selectSecurity(userId);
            try {
                m.setUserName(OpenCrypt.aesDecrypt(m.getUserName(),
                        OpenCrypt.hexToByteArray(sec.getSecKey())));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return m;
        }
    }
}*/
