package suite

import org.junit.runner.RunWith
import org.junit.runners.Suite
import tests.users.GetAllUsersTest

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GetAllUsersTest::class,
    GetAllUsersTest::class,
    GetAllUsersTest::class,
)

class Suite