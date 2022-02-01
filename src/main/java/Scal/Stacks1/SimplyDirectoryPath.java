package Scal.Stacks1;

import java.util.List;
import java.util.Stack;

/*
Given a string A representing an absolute path for a file (Unix-style).
Return the string A after simplifying the absolute path.

Note:
    Absolute path always begin with '/' ( root directory ).
    Path will not have whitespace characters.

    Input 1:
    A = "/home/"
Output 1:
    "/home"

Input 2:
    A = "/a/./b/../../c/"
Output 2:
    "/c"

 */
public class SimplyDirectoryPath {
    public static String simplify(String A){
        if (A==null ) return null;
        Stack<String> stack = new Stack<>();
        // Split the input
        String [] data= A.split ("/");
        for (String s : data){
            if (s.equalsIgnoreCase(".") || s.equalsIgnoreCase("")) continue;
            else if (s.equalsIgnoreCase("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else stack.push(s);
        }

        // Final Step - Alternative way of appending final result
        //List<String> list = new ArrayList(stack);
        // return "/" + String.join("/", list);

        // Final Step - this to avoid TLE since it was happening for too larger input
        String res="";
        String res1="";
        while (!stack.isEmpty()){
            res1 = "/"+stack.pop();
            //append to first before 2nd character .. like attach to head node concept
            res = res1+ res;
        }
        return res==null? "/" : res;


    }
    public static void main(String[] args) {
        System.out.println(simplify("/home//foo/"));
        //System.out.println(simplify("/wkr/sjy/fhs/puz/kqv/yau/uya/bcp/htk/fyo/iuq/jdb/ovh/bjq/tck/xua/gzi/eha/mgv/xkl/wgi/czo/gnh/gqe/zeb/diw/dfe/wbd/tnm/nqe/qlp/ncm/nod/pmr/qmi/woy/com/lwg/kax/ysd/zpo/kth/kkl/gbo/ogx/dfv/cgo/mch/lzi/gsa/vyd/lwc/xnv/iun/ber/cvt/qls/doj/thf/jrs/kgu/jym/ian/djh/cuz/xeo/qxy/dvz/qrk/kli/wnx/bvt/uib/ghj/xdw/naq/dse/toz/qyz/psm/csn/tph/fzd/fht/yoe/muc/cjz/tkx/hnr/gvk/vcf/mve/nbc/gad/whp/dnu/awf/wsx/vma/bbq/gid/feu/nnq/hqf/cbd/yer/kvq/icb/cwk/doy/usi/iwl/xxk/ugb/hxw/hod/qcz/rfa/tdn/hri/mtn/kxe/haj/oql/opf/btj/sce/jmh/lua/ofh/ubg/gej/nsh/wqt/vlr/alp/ked/isc/bxz/cqt/iet/bkq/sxa/rej/xwv/trp/bla/aom/ijt/pfu/wlj/qxu/yfd/uaj/nik/yak/tux/uxd/qyz/egr/enl/btw/pks/vdn/int/njr/gus/zto/fbi/rml/xyk/vht/xyu/wbk/ilj/mli/ymb/xjo/awv/cqq/wny/qvv/lxr/igw/xpv/rtb/jzg/rlg/kam/maf/tvc/gbq/ymn/wpf/wsa/ouk/rsu/aei/eel/uch/cnv/yxl/hdp/gyi/dpy/kzu/jfk/ohe/ojh/gxr/hww/voi/yfg/tdf/nmo/ofj/rmw/ufh/qme/lkc/qkv/qrq/jpc/usq/ezs/wmg/ykw/rqx/yej/lkm/lrf/mhm/hda/sfj/xun/nyz/cst/vje/tgi/cye/qwi/wyt/ssg/hiw/onz/qmk/epx/ulk/aof/szf/dcl/qtx/lnx/wdr/kaa/cwm/xbi/nik/boo/tnd/wju/qbp/nbk/opa/xgx/kaq/rpj/ylf/hqh/can/aem/ntg/tmo/buz/nod/zxd/hqg/enc/zky/jug/bqh/pmd/fpn/nhq/isv/ims/mmm/skn/hyk/ujx/lcd/fvp/txv/dpm/wdb/iba/ntv/pte/rnd/zft/uud/ijo/igk/ghr/pap/jmh/mcs/inu/ztf/voq/tqi/jxq/zux/mia/yui/bst/pqu/dfl/tix/rdi/ejv/igu/bbb/dae/rhg/oqi/vgh/jmn/ldr/pzx/vlm/mkz/ohe/zrk/wnz/sxi/xvf/pto/cgj/exj/biw/xun/ywn/gbz/olp/ppz/qdn/tpc/mtj/wue/qmx/sww/yln/kde/lwz/kzz/yki/fro/ozs/gdr/vnc/win/fph/xrz/hzw/yvq/ecd/tgo/ysk/rni/kgd/hip/ayr/gjj/uol/hkt/reb/vnv/plh/eyq/etl/kre/lky/nec/axa/wct/kvr/nbp/jsr/afk/doc/axc/bly/nje/bsw/sdk/eno/zou/lkq/ffn/thp/agb/aka/amk/ecf/xur/pck/xiz/ftx/nax/lqv/qzp/mwf/bwj/zye/vec/eup/jzy/xya/lwc/dar/kkf/hix/oxq/tkj/jtk/cje/cbc/hes/aav/agj/fsn/wmn/pzr/ciw/lgm/tbg/ony/nhg/doy/yrf/lph/rni/zvs/ban/olf/qiz/peu/jjz/gbe/ntb/fov/stu/qyh/lqy/exj/qcf/esv/btn/wsz/rvv/ych/wye/nye/rxb/jzq/okp/kih/xsz/def/ogk/jfu/usa/csl/irj/guq/smk/zfm/kbs/yle/rfn/luy/tpl/wml/rud/eoa/ivh/vvk/gcn/esw/nob/hkq/xbc/ysm/ugz/fiv/fcu/rgd/leu/cdj/oik/tgu/gap/txa/wtm/zkg/hhd/iye/anz/xua/etc/cbz/yvr/rzp/jry/qox/ohk/jgf/hmv/irm/bcp/ulb/yve/uoa/bqp/ttm/qab/hwj/rcf/ahv/koo/etj/fut/mcc/gib/jks/sjd/eah/fpg/fbw/lwp/poz/jxa/dxd/pyg/byr/gmh/mmj/mrn/ixb/voo/iwp/iun/mpp/atu/baq/jpa/jlh/bbx/ckq/gsy/acq/dmc/yml/cpk/vzw/err/gpe/tgh/qzq/agf/lja/eaz/wky/ypd/pyg/gnh/ydn/kvi/owp/huy/aig/hlt/mxe/jtr/sgf/xxo/urf/jjn/ywx/rme/anb/opl/zsa/eqf/zvt/yjo/nkj/tsc/wmz/mqf/fgq/ilx/iqe/lgt/fzp/knu/zlq/are/skc/lrq/hbq/nkn/lzs/hku/hva/kly/vff/stp/uig/tpk/pao/dfe/kyt/pxe/zsy/ajw/rmp/rac/xuj/zuc/nmc/xxh/ptc/zmx/nty/lhf/cck/xvo/ukk/pfs/ied/oaz/krx/zni/wtz/nhh/hrd/syr/zhp/tfc/twl/eel/lgt/uce/blm/qcb/ntn/smf/uai/hcp/vmu/lbv/jps/oin/vfp/htg/oww/awa/vjx/ris/vdo/dyh/ynl/ajf/fzy/yor/srb/tzr/nhx/xng/ydg/zmi/xnw/zni/sox/dln/yak/ewp/spf/ogj/naz/rzw/rcg/pfq/nzp/rsx/zks/nly/ywj/ros/szd/xpg/rst/zwy/qly/uly/xnq/asr/qho/lrd/kli/dmm/rnf/jwn/mxq/zcq/qwl/cqq/oex/mst/wpd/jkb/rgg/mwg/hgl/exq/pzp/qwl/yec/ufl/yew/rna/sfr/vsv/ona/rsu/tvy/vmr/ydo/jxf/fqv/rvn/mrs/aea/hmo/wnd/hhp/vov/wmq/bwc/nbi/wqk/whw/uaj/yge/vnb/mbn/rxy/fvh/wpv/lso/rti/yom/jig/gcd/ooi/buj/klc/jel/kio/irm/spe/mfa/ztt/udh/kig/gfi/xci/kzz/vug/mvo/wyp/fcz/mgm/ild/tpw/wdw/ucr/qwh/wgt/eai/yws/hzm/rzp/ztq/pqd/xym/anz/gkm/pwr/beg/jvm/nub/yfd/jmv/ejw/pac/moi/mti/fkk/sak/vbj/gue/imb/gsy/mty/oiv/udi/kjn/eyg/umf/asr/gch/xta/xsy/dfz/kab/jar/txk/mwf/vsn/yoz/yav/lpp/tsf/fqe/aom/nwg/byh/mqh/zew/vsv/axg/ccd/ohj/jkk/bhj/vlg/hzo/loe/tvm/eso/jqw/hjv/wzc/vqe/oxw/dkd/qfn/zhz/ypb/rev/ogi/ztp/xys/rkw/tom/uzj/tux/tvv/dkp/ktk/vqy/mae/gkx/ahf/pch/wmn/zsr/mvk/qdg/yes/aok/mbb/zzi/aad/pfp/ypy/wme/ezv/eos/ufh/qdr/pmv/qbc/dqb/uat/bim/wyn/xoe/pve/dff/ssm/svr/ouf/lqd/aqt/wle/hbn/idv/sjv/npv/gzk/qkk/qmk/goi/zis/pgp/hpm/yvh/xmq/phy/olr/dfc/gil/hga/kkv/bsg/nqc/jrl/khn/aln/miw/pow/kpy/ckh/ehx/xfc/ubj/eyf/vtl/xhn/afl/ild/hsx/tbu/rki/waz/fxo/nez/kts/pej/crv/bux/byt/hyh/uqi/ujt/bkz/hay/rxu/tgd/bdg/ppp/mcv/vip/xom/ohy/brb/kjq/fwa/dmy/oms/tra/zrv/ved/nca/yvb/byj/zkt/vfg/pdj/dkz/ypb/lri/aew/dos/suy/wby/wfa/yso/abn/wzt/jqe/pnd/hdm/rsi/nxb/alu/crh/bje/vxk/zxe/kox/pyw/fng/xem/eqh/wid/cov/miq/xmq/emp/kcl/xcd/jme/kqv/lbl/ist/fes/nvc/ypn/zvk/hme/acj/ije/hvy/aue/ixa/cor/zmq/apa/giq/opy/jqs/spi/ciq/emq/jgm/tgb/wff/jmj/flv/lzg/smr/asv/uuc/bla/afi/qyy/itp/qkl/nip/ucy/elq/urd/fwg/qft/fns/jah/dlk/zen/rfv/bqy/uub/phr/ibt/bdp/ule/pcq/vzq/mra/ltr/qbh/afj/fme/dbx/lbl/ddc/ksa/mob/gby/bhe/ulu/tot/osh/kze/zxn/tgc/crh/ehw/yxk/izg/rgc/ctw/btp/wuh/gio/eif/bek/gap/gsd/olv/wod/ozc/hlp/mxo/aej/uqp/xkf/xxw/usa/dyb/aly/hju/drb/dpc/tyh/eri/xyx/nse/mue/eao/nqn/ilu/wul/xox/dkb/eur/yzs/pnf/nzf/iit/qcq/aqv/tza/xxf/vea/ucl/iwu/sml/dhr/bfc/nmy/ljm/ygd/fpf/sdx/lbh/gyd/osf/hck/bdd/pqw/vaj/qqx/mxj/xnh/old/rjq/eap/awq/ger/gxg/zxf/rli/jhg/aho/jiy/iam/oer/awj/isx/okg/vim/eiz/boh/zmo/qvx/dcr/qls/tbr/wcv/lqi/tnf/xzp/mkg/rxn/usk/qcn/lce/gqc/mhl/dlw/psd/ags/fxq/wmb/wmh/ept/cku/srz/htb/hgs/xpt/rev/tks/yss/xkb/owb/otj/dbj/vsu/lcy/rfe/asu/frj/igr/bxj/nvn/xog/aud/sxr/lom/xng/lao/heh/udz/wye/fji/ckv/fnf/lsu/bab/euz/nxa/umd/ksu/epa/yry/zbq/hrr/mkg/hoc/vrb/fij/ani/uoz/dnu/nsb/bdi/xfv/wfu/rhu/ctj/deq/asj/jhj/zdf/cif/vwb/xqx/hxi/rgs/tjw/mgb/zfs/axs/dal/lkh/scy/dtd/fue/shm/qbs/sch/hif/hqu/kvg/yht/aom/sfh/xza/bub/rpe/ayx/kxa/nte/hmu/obv/rou/vdg/ear/anh/eqb/mzn/reo/kwk/uit/jpg/mow/lps/osm/rhj/qco/onp/hdq/zpk/pwg/ukm/stt/plb/ldc/hjj/hqh/pir/ycz/gjy/hbk/olh/wgz/wyo/fqk/flq/ugt/fcu/qvt/jdt/uqc/gef/zno/yzt/qty/dyw/vak/coq/hch/cao/tfd/bpc/hdk/ngn/fwf/eml/ssa/fue/gda/irp/ojy/lmq/pty/tqg/vwa/sui/orz/jde/ndi/qkr/saf/tvg/swm/spz/dme/dwt/pit/wbj/lvu/fzb/wjo/tem/gsc/ctm/kwg/zjf/xwt/pjo/txc/ddf/fgs/fad/pkm/dfg/euj/zfd/mez/dfp/sfp/nuk/yhu/lpz/cib/cpp/tkn/jsm/vsz/ssv/puv/aiq/hlk/pdg/tzk/ygs/uab/imn/ezy/xfl/udm/wdl/vie/adn/job/cgz/gvz/psb/xik/qxr/wsa/sma/dso/znf/zhy/rud/qyr/tog/ikk/ufu/szn/nyw/coy/qxp/eer/nsi/lhu/ivb/ghi/ijg/yxn/lce/fqe/yga/ffx/mmb/daz/slh/dgg/dlo/utz/bbp/ueq/vol/slu/aan/bzg/vco/aba/hzq/bgn/ece/zzx/pmh/lsl/wzk/mfk/ftr/npa/rhq/bdx/zwz/qxs/gbd/hxv/vtf/idm/amh/gmu/ouu/siy/fye/wti/zyt/xfo/ajy/vak/nkg/cez/ooe/ryb/xvw/pqg/mpx/bad/cew/pau/qrf/kvi/wqu/jsk/xkk/lsq/dzq/wql/fun/thy/wet/iad/bst/fwd/oue/ssi/gkc/wyb/fnb/flf/ssh/pwv/gnd/wzj/hko/lej/klq/qlr/ixl/hhx/hqx/hxp/lvf/zfm/wqn/bni/swy/yai/yjh/ywc/kiz/cfu/pkv/lro/cpw/igb/ncx/tsk/pad/lie/tun/xhw/fzj/ejx/ers/aum/yuv/mpo/wrs/dqt/jop/rxz/uhs/hqz/tin/cln/owq/xsd/nxt/wlw/lpg/kvl/ohj/dlm/wpq/sya/zqv/dgh/peh/tca/nit/joj/zex/mau/fud/rmh/mvg/nxe/rdr/cim/iiv/tbb/ojf/upg/mzh/kya/edx/uqi/qio/kwi/jba/fwg/xrv/pzj/esf/iaz/jfu/eci/qcc/vae/ian/sog/xhf/psw/xha/aeb/yqh/knj/sns/rvd/wbv/rey/ohj/dnu/pvs/bfc/uju/aiy/jsd/etz/yxv/svz/vnw/kya/cje/cni/kcw/rng/dah/bvg/pea/eiu/cky/jct/dcu/bhw/qmg/ogk/ywq/bxi/yzb/aio/hco/pll/xnt/uck/yrm/jhp/jli/ihy/cdx/qwg/azy/isb/hqp/jhs/iec/xnn/vnx/qit/awy/qeu/nmg/ios/tpi/pju/zzm/mhi/oso/olw/ytl/iui/ucd/qlf/wgt/ytg/bhy/nfx/ves/vzt/zzr/dcv/rky/nhw/xzn/jnl/mts/zja/rfu/gev/idf/mnh/btj/ept/jyf/iyb/xnt/kyf/nfk/eld/arj/beb/okf/qfg/uvg/opn/bom/qpu/est/rsv/tbe/pic/djj/bbn/csj/ydn/oda/zav/wgn/nxo/muk/rkc/ffk/dtx/mpd/tzu/gtk/qpm/fjq/kqr/qvw/mnh/xwm/xlk/fpb/pmo/yto/edr/fvu/krq/nbl/uni/wjn/uyx/lnx/bgy/wzz/rfd/pae/abz/vhp/sjk/hkt/wqk/zvc/utn/zku/sgr/kkw/oyb/bej/opk/thz/vbh/len/vbt/tmw/zag/thh/vhz/lnp/wgu/lqt/ims/svo/piw/tme/qfh/gzo/dsy/rsi/enb/yfe/fju/bup/pcw/eze/swp/tlc/pdl/pbo/cqi/wex/utk/auq/lsp/xie/zba/wgn/eks/udu/gpa/mjz/grm/chq/ubx/fnm/rtg/toq/mlw/sbw/mhm/gmg/xme/nvx/bos/dln/sfp/jte/vfz/mue/avb/clx/fzx/dfd/tzf/jkg/hjp/kif/sqh/jky/xpu/fbt/zsl/ojz/duy/hgi/mph/dhl/hoa/ehy/qrj/yjp/vzh/rwy/cbq/eko/oqq/les/rrn/vja/bqu/unq/pfu/fur/vem/hfb/fzn/eee/guv/qwo/wsn/wfp/akm/pyg/rok/hxh/vqw/jyn/zgl/nbm/ztl/atb/yti/klb/ivy/dgm/iuq/fyo/wll/zop/oko/kif/ywe/fjw/too/cvx/esp/ign/nbo/sct/gis/rro/nbf/uob/ypm/zap/dpp/hyo/shh/cjs/dok/cvq/shm/hfd/xvo/wro/lta/wxb/ebl/zkz/lwf/vxo/ldz/ccg/utc/rxf/whl/gts/swi/sms/aaf/xrh/xqi/iac/zlk/upm/wjn/hao/xkl/fwl/nzj/lck/usl/iid/oxs/iwh/muj/vgg/fvd/hvf/nrn/bpg/fzn/pec/fjz/bpl/qmi/bjt/gsj/qqx/coo/mkd/ewk/nkq/qkb/onh/wlu/otj/fmk/zeq/gbc/fuq/mtl/sih/yxh/ahk/her/fqr/qvc/rjt/dwa/mti/uou/hud/oyd/rvk/ike/byx/cvw/dmr/xzs/hii/irz/akd/zfu/egv/nyw/huw/qet/agd/wjw/ccz/ogu/ufr/zlj/qda/odv/msx/dsx/xxm/udf/vwv/wpx/nop/bqv/jut/sxp/szy/chf/fta/bjo/jii/ewu/fld/iol/nvd/sob/atv/tfb/cro/eeo/pwj/gjz/tiu/gbi/uhl/lek/wsl/mpp/pcm/xxu/flz/nzt/jny/nps/yai/bcf/rsx/kpd/gop/tzw/ymv/zel/ikl/eeg/zja/dad/ndq/jjm/cil/zlu/apt/rwf/ygb/uur/zkj/kge/ahh/qae/clg/xow/daw/vra/zej/ziq/thz/nof/zdh/nfb/eaw/deg/tza/dbk/gsq/vjy/chr/zpq/uzn/mzx/coy/buk/jwd/rpa/def/adf/gvs/vdw/vnd/zax/row/vhy/rvf/pxf/cjp/mkq/tme/ril/jty/xlw/jet/suk/vmz/jfy/jsb/ikl/tid/nve/kqk/prs/upk/mkc/jxp/sym/wtb/gtn/xbd/nem/lvr/bmq/gcr/jwo/fss/tll/zub/xkb/aql/rjs/uvk/sph/vvb/ggf/zzq/trj/vtu/xkh/cjx/yvu/gpn/lbr/fqz/kun/mrs/tvd/huz/rnw/oen/zyj/onk/rsz/zrt/cmc/jsy/ksl/kta/tgv/vnl/thh/xao/dgx/qwe/ens/dja/wqa/flj/exn/fir/oes/ygg/tcf/kbk/jft/eff/dqh/jpg/vjf/ldt/ybx/loq/auv/efk/uwj/bxt/jao/lfw/dzf/rtw/eti/vgj/xqk/xit/ufx/gte/ous/gtn/zjr/vpn/gfe/usc/qis/zhw/cch/gtp/tty/mcv/iob/blz/ecs/ogs/vub/won/oqu/ipl/whn/qsq/pnv/geu/tzn/wti/kqn/lqd/ktt/gku/zoh/ymm/eav/jfq/hby/jli/hzu/afr/wgs/jcj/hfb/hjs/yjk/hbj/dng/fwm/nai/cap/svo/rjm/rix/nrc/jqz/mfw/bxq/zov/mrs/ayv/wdd/xvt/ujs/fjq/yaf/svk/mrq/oew/oqb/xpy/dyo/ejy/znd/grs/fip/qek/zce/ovo/opn/mjv/oor/umk/lmb/blj/dfk/xgi/hhl/eks/iyi/ged/brn/utp/gpf/xin/iiq/ppr/gpe/wne/qqc/igz/rce/zrg/zdv/shj/cpc/xmi/mgv/xek/udm/rce/exm/nlr/yzu/ruf/hcc/rgm/rbb/rij/ekh/zkk/amk/jlq/gnn/siy/hrt/uhr/qnl/mkl/grq/zgd/hyu/dcm/jft/kph/czo/ofa/qbg/bhy/pjk/epe/yxh/xnc/xql/pyb/acm/amn/snw/ghc/bjy/sph/bmd/omp/mdh/fkr/ccw/wev/zam/xss/wfl/vxt/mzq/kjy/mjq/xsl/ayc/nhd/qfb/gnz/vlm/xzx/zxx/tim/bky/txd/qpq/afk/tdc/ogs/awh/rxb/fkw/ikw/ugb/rkm/qeo/vni/nfd/mvk/ixz/lwr/lou/pzz/fad/sox/khh/inx/jzk/bzk/aiq/osg/eag/tbr/hwv/nbx/bey/njk/scr/gel/vsp/yyk/fci/tld/dde/ltx/lrx/uwp/rjh/xux/iyh/jxe/lkb/evd/asm/cvi/ssv/iqk/uhf/cuu/csz/qjb/dwf/obf/uum/dnn/txy/iip/zak/yzc/zvw/rtv/qin/far/nzw/dus/xqn/fjm/jlr/wvd/akh/szy/cxz/ure/rdg/kmt/uzv/uyy/tfp/fxo/iaa/grz/jcw/xxk/kxu/ami/dfm/hpk/hoj/oyw/xnd/ehj/maw/lnk/exp/ula/qem/cts/jwk/bzr/rhg/sii/bnz/mce/qay/wij/gjz/fdd/urc/hmv/fqj/gpy/csg/lhv/vvs/wbr/uiy/mav/grd/zvf/rsl/kdi/agl/yre/xbh/kvq/..."));
    }
}
