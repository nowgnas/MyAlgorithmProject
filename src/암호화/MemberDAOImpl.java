/*
package 암호화;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class MemberDAOImpl extends SqlMapClientDaoSupport implements MemberDAO {

    @Override
    public void insertMember(MemberModel memberModel) {
        getSqlMapClientTemplate().insert("member.addMember", memberModel);
    }

    @Override
    public MemberModel selectMember(String userId) {
        return (MemberModel) getSqlMapClientTemplate().queryForObject("member.findByUserId", userId);
    }

    @Override
    public void deleteMember(MemberModel memberModel) {
// TODO Auto-generated method stub
        getSqlMapClientTemplate().delete("member.deleteMember", memberModel);
    }

    @Override
    public void updateMember(MemberModel memberModel) {
// TODO Auto-generated method stub
        getSqlMapClientTemplate().update("member.updateMember", memberModel);
    }

    @Override
    public void insertSecurity(SecVO sec) {
        getSqlMapClientTemplate().insert("member.insertSecurity", sec);
    }

    @Override
    public SecVO selectSecurity(String userId) {
        return (SecVO) getSqlMapClientTemplate().queryForObject("member.selectSecurity", userId);
    }
}*/
