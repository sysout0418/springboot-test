<jsp:include page="../common/header.jsp" flush="true"/>

<!--================login Area =================-->
<section class="login_area p_100">
    <div class="container">
        <div class="login_inner">
            <div class="row">
                <div class="col-lg-4">
                    <div class="login_title">
                        <h2>log in your account</h2>
                        <p>Log in to your account to discovery all great features in this template.</p>
                    </div>
                    <form class="login_form row" action="/user/login" method="post">
                        <div class="col-lg-12 form-group">
                            <input class="form-control" type="text" name="username" maxlength="11" placeholder="Phone Number">
                        </div>
                        <div class="col-lg-12 form-group">
                            <input class="form-control" type="password" name="password" placeholder="Password">
                        </div>
                        <div class="col-lg-12 form-group">
                            <div class="creat_account">
                                <input type="checkbox" id="f-option" name="selector">
                                <label for="f-option">Keep me logged in</label>
                                <div class="check"></div>
                            </div>
                            <h4>Forgot your password ?</h4>
                        </div>
                        <div class="col-lg-12 form-group">
                            <button type="submit" value="submit" class="btn update_btn form-control">Login</button>
                        </div>
                    </form>
                </div>
                <div class="col-lg-8">
                    <div class="login_title">
                        <h2>create account</h2>
                        <p>Follow the steps below to create email account enjoy the great mail.com emailing experience.
                            Vivamus tempus risus vel felis condimentum, non vehicula est iaculis.</p>
                    </div>
                    <form class="login_form row" action="/user/join" method="post">
                        <div class="col-lg-6 form-group">
                            <input class="form-control" type="text" name="mdn" placeholder="Phone Number">
                        </div>
                        <div class="col-lg-6 form-group">
                            <input class="form-control" type="email" name="email" placeholder="Email">
                        </div>
                        <div class="col-lg-6 form-group">
                            <input class="form-control" type="text" name="profileName" placeholder="User Name">
                        </div>
                        <div class="col-lg-6 form-group">
                            <input class="form-control" type="password" name="accountPassword" placeholder="Password">
                        </div>
                        <div class="col-lg-6 form-group">
                            <input class="form-control" type="password" placeholder="Re-Password">
                        </div>
                        <div class="col-lg-6 form-group">
                            <button type="submit" value="submit" class="btn subs_btn form-control">register now</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End login Area =================-->

<jsp:include page="../common/footer.jsp" flush="true"/>